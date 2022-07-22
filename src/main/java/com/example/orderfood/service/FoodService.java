package com.example.orderfood.service;

import com.example.orderfood.entity.Food;
import com.example.orderfood.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FoodService {
    final FoodRepository foodRepository;
    public Food save(Food food) {
        return foodRepository.save(food);
    }
    public Page<Food> findAll(int page, int limit){
        return foodRepository.findAll(
                PageRequest.of(page-1, limit, Sort.Direction.ASC,"id"));
    }
    public Optional<Food> findById(Long id) {
        return foodRepository.findById(id);
    }
    public void deleteById(Long id) {
        foodRepository.deleteById(id);
    }

}
