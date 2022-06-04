package com.koapti.lazychef.http.controller.food;

import javax.validation.Valid;

import com.koapti.lazychef.api.model.Food;
import com.koapti.lazychef.api.model.FoodList;
import com.koapti.lazychef.http.HttpConstants;
import com.koapti.lazychef.http.exceptions.FoodNotFoundException;
import com.koapti.lazychef.http.handler.food.CreateFoodHandler;
import com.koapti.lazychef.http.handler.food.DeleteFoodHandler;
import com.koapti.lazychef.http.handler.food.GetFoodDetailsHandler;
import com.koapti.lazychef.http.handler.food.GetFoodsHandler;
import com.koapti.lazychef.http.handler.food.UpdateFoodHandler;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor(staticName = "of")
@RequestMapping(HttpConstants.FOOD_HTTP_ENDPOINT)
public class FoodController {

    private CreateFoodHandler createFoodHandler;
    private DeleteFoodHandler deleteFoodHandler;
    private GetFoodDetailsHandler getFoodDetailsHandler;
    private GetFoodsHandler getFoodsHandler;
    private UpdateFoodHandler updateFoodHandler;


    @ApiOperation(value = "", nickname = "createFood", notes = "Create food", response = String.class)
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Food created successfully", response = String.class)})
    @PostMapping
    public ResponseEntity<String> createFood(@ApiParam(value = "Food details to create", required = true) @Valid @RequestBody final Food food) {
        String id = createFoodHandler.handle(food);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    @ApiOperation(value = "", nickname = "deleteFood", notes = "Delete food")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Food deleted successfully")})
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFood(@ApiParam(value = "The ID of the specific food you want to delete.", required = true)
                                           @PathVariable("id") final String id) {
        deleteFoodHandler.handle(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value = "", nickname = "getFoodList", notes = "Get food list", response = FoodList.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Food list", response = FoodList.class)})
    @GetMapping
    public ResponseEntity<FoodList> getFoodList() {
        return new ResponseEntity<>(getFoodsHandler.handle(), HttpStatus.OK);
    }

    @ApiOperation(value = "", nickname = "getFoodDetails", notes = "Get food details", response = Food.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Food details", response = Food.class)})
    @GetMapping("/{id}")
    public ResponseEntity<Food> getFoodDetails(@ApiParam(value = "The ID of the specific food for which you want details.", required = true)
                                               @PathVariable("id") final String id) {
        try {
            Food food = getFoodDetailsHandler.handle(id);
            return new ResponseEntity<>(food, HttpStatus.OK);
        } catch (final FoodNotFoundException foodNotFoundException) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation(value = "", nickname = "updateFood", notes = "Update food", tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Food updated successfully")})
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateFood(@ApiParam(value = "The ID of the specific food which you want to edit.", required = true)
                                           @PathVariable("id") final String id, @ApiParam(value = "Food details to update", required = true)
                                           @Valid @RequestBody final Food food) {
        updateFoodHandler.handle(id, food);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
