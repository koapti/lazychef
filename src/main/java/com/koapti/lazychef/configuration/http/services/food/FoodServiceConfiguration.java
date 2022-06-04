package com.koapti.lazychef.configuration.http.services.food;

import com.koapti.lazychef.http.service.FoodService;
import com.koapti.lazychef.repository.FoodRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FoodServiceConfiguration {

    @Bean
    public FoodService foodService(final FoodRepository foodRepository) {
        return FoodService.of(foodRepository);
    }
}
