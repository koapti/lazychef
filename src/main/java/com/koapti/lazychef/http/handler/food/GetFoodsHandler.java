package com.koapti.lazychef.http.handler.food;

import java.util.List;
import java.util.stream.Collectors;

import com.koapti.lazychef.api.model.FoodList;
import com.koapti.lazychef.model.entity.Food;
import com.koapti.lazychef.model.mappers.api.FoodApiMapper;
import com.koapti.lazychef.repository.FoodRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor(staticName = "of")
public class GetFoodsHandler {
    private final FoodRepository foodRepository;

    public FoodList handle() {
        List<Food> allFoods = foodRepository.findAll();
        return FoodList.of(allFoods.stream().map(FoodApiMapper::toApiFood).collect(Collectors.toList()));
    }
}
