package com.koapti.lazychef.http.handler.food;

import com.koapti.lazychef.repository.FoodRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor(staticName = "of")
public class DeleteFoodHandler {

    private final FoodRepository foodRepository;

    public void handle(final String id) {
        foodRepository.deleteById(Integer.parseInt(id));
    }

}
