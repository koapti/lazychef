package com.koapti.lazychef.configuration.http.handlers.food;

import com.koapti.lazychef.configuration.http.services.food.FoodServiceConfiguration;
import com.koapti.lazychef.http.handler.food.CreateFoodHandler;
import com.koapti.lazychef.http.handler.food.DeleteFoodHandler;
import com.koapti.lazychef.http.handler.food.GetFoodDetailsHandler;
import com.koapti.lazychef.http.handler.food.GetFoodsHandler;
import com.koapti.lazychef.http.handler.food.UpdateFoodHandler;
import com.koapti.lazychef.http.service.FoodService;
import com.koapti.lazychef.repository.FoodRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(FoodServiceConfiguration.class)
public class FoodHandlersConfiguration {

    @Bean
    public CreateFoodHandler createFoodHandler(final FoodRepository foodRepository, final FoodService foodService) {
        return CreateFoodHandler.of(foodRepository, foodService);
    }

    @Bean
    public DeleteFoodHandler deleteFoodHandler(final FoodRepository foodRepository) {
        return DeleteFoodHandler.of(foodRepository);
    }

    @Bean
    public GetFoodDetailsHandler getFoodDetailsHandler(final FoodRepository foodRepository) {
        return GetFoodDetailsHandler.of(foodRepository);
    }

    @Bean
    public GetFoodsHandler getFoodsHandler(final FoodRepository foodRepository) {
        return GetFoodsHandler.of(foodRepository);
    }

    @Bean
    public UpdateFoodHandler updateFoodHandler(final FoodRepository foodRepository) {
        return UpdateFoodHandler.of(foodRepository);
    }
}
