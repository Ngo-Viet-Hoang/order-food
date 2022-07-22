package com.example.orderfood.controller;

import com.example.orderfood.entity.Food;
import com.example.orderfood.service.FoodService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping(path = "api/v1/foods")
@Slf4j
@RequiredArgsConstructor
public class FoodController {
    final FoodService foodService;
    @RequestMapping(path = "/create", method = RequestMethod.GET)
    public String createFood(Model model){
        model.addAttribute("food",new Food());
        return "view/foods/create";
    }
    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public String processSaveFood(@Valid @ModelAttribute("food") Food food,
                                  BindingResult bindingResult,
                                  Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("food",food);
            return "view/foods/create";
        }
        foodService.save(food);
        return "redirect:/admin/foods/create";
    }
    @RequestMapping(path = "list" , method = RequestMethod.GET)
    public String findAll(@RequestParam(value = "page",defaultValue = "1") int page,
                          @RequestParam(value = "limit",defaultValue = "10")int limit,
                          Model model){
        model.addAttribute("Pageable",foodService.findAll(page, limit));
        return "view/foods/list";
    }
    @RequestMapping(method = RequestMethod.PUT, path = "{id}")
    public ResponseEntity<Food> update(@PathVariable Long id, @RequestBody Food food) {
        Optional<Food> optionalFood = foodService.findById(id);
        if (!optionalFood.isPresent()) {
            ResponseEntity.badRequest().build();
        }
        Food existFood= optionalFood.get();
        // map object
        existFood.setName(food.getName());
        return ResponseEntity.ok(foodService.save(existFood));
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if (!foodService.findById(id).isPresent()) {
            ResponseEntity.badRequest().build();
        }
        foodService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
