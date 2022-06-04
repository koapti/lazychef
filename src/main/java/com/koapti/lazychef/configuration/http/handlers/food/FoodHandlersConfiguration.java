package com.koapti.lazychef.configuration.http.handlers.food;

import com.koapti.lazychef.http.handler.food.CreateFoodHandler;
import com.koapti.lazychef.http.handler.food.DeleteFoodHandler;
import com.koapti.lazychef.http.handler.food.GetFoodDetailsHandler;
import com.koapti.lazychef.repository.FoodRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FoodHandlersConfiguration {

    @Bean
    public CreateFoodHandler createFoodHandler(final FoodRepository foodRepository) {
        return CreateFoodHandler.of(foodRepository);
    }

    @Bean
    public DeleteFoodHandler deleteFoodHandler(final FoodRepository foodRepository) {
        return DeleteFoodHandler.of(foodRepository);
    }

    @Bean
    public GetFoodDetailsHandler getFoodDetailsHandler(final FoodRepository foodRepository) {
        return GetFoodDetailsHandler.of(foodRepository);
    }
}
