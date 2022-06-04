package com.koapti.lazychef.http.handler.food;

import com.koapti.lazychef.api.model.Food;
import com.koapti.lazychef.http.exceptions.FoodAlreadyExistsException;
import com.koapti.lazychef.http.service.FoodService;
import com.koapti.lazychef.model.mappers.entity.FoodEntityMapper;
import com.koapti.lazychef.repository.FoodRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor(staticName = "of")
public class CreateFoodHandler {

    private final FoodRepository foodRepository;
    private final FoodService foodService;

    public String handle(final Food food) throws FoodAlreadyExistsException {
        if (foodService.isFoodAlreadyExists(food.getName())) {
            throw new FoodAlreadyExistsException("Food with name \"" + food.getName() + "\" already exists.");
        }
        com.koapti.lazychef.model.entity.Food save = foodRepository.save(FoodEntityMapper.toFoodEntity(food));
        return save.getId().toString();
    }
}
