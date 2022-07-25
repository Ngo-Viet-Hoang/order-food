//package com.example.orderfood.service;
//
//import com.example.orderfood.OrderFoodApplication;
//import com.example.orderfood.entity.*;
//import com.example.orderfood.entity.entityEnum.OrderStatus;
//import com.example.orderfood.repository.CategoryRepository;
//import com.example.orderfood.repository.FoodRepository;
//import com.example.orderfood.repository.OrderRepository;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.stereotype.Component;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.time.LocalDateTime;
//import java.util.HashSet;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@Component
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = OrderFoodApplication.class)
//
//class FoodServiceTest {
//    @Autowired
//    FoodRepository foodRepository;
//    @Autowired
//    CategoryRepository categoryRepository;
//    @Autowired
//    OrderRepository orderRepository;
//
//
//
//    @Test
//    public void testFood() {
//
//        Category category = new Category();
//        category.setName("nuongw");
//        categoryRepository.save(category);
//        Food food1 = Food.FoodBuilder.aFood()
//                .name("com")
//                .category(category)
//                .build();
//        foodRepository.save(food1);
//
//        List<Food> foods = foodRepository.findAll();
//        foods.forEach(e->{
//            System.out.printf("Foods: "+ e.getName());
//        });
//        Order order = Order.builder()
//                .id(System.currentTimeMillis())
//                .createdAt(LocalDateTime.now())
//                .status(OrderStatus.STOP)
//                .build();
//        System.out.println("Order: "+ order.getId());
//        HashSet<OrderDetail> orderDetails = new HashSet<>();
//        for(Food food :
//                foods){
//            OrderDetailId orderDetailId = new OrderDetailId();
//            orderDetailId.setOrderId(order.getId());
//            orderDetailId.setFoodId(food.getId());
//            OrderDetail orderDetail = OrderDetail.builder()
//                    .orderDetailId(orderDetailId)
//                    .order(order)
//                    .food(food)
//                    .image("image1")
//                    .description("do an ngon")
//                    .quantity(10)
//                    .unitPrice(0)
//                    .createBy("hello")
//                    .updatedBy("eeo")
//                    .build();
//            orderDetails.add(orderDetail);
//        }
//
//        order.setOrderDetails(orderDetails);
//        orderRepository.save(order);
//        System.out.println("Hello");
//    }
//}