package com.koapti.lazychef.http.controller.ordersfood;

import javax.validation.Valid;

import com.koapti.lazychef.api.model.OrdersFood;
import com.koapti.lazychef.http.HttpConstants;
import com.koapti.lazychef.http.handler.ordersfood.UpdateOrdersFoodHandler;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor(staticName = "of")
@RequestMapping(HttpConstants.ORDERS_FOOD_HTTP_ENDPOINT)
public class OrdersFoodController {

    private UpdateOrdersFoodHandler updateOrdersFoodHandler;


    @ApiOperation(value = "", nickname = "updateOrdersFood", notes = "Update food in order")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OrdersFood updated successfully")})
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateOrdersFood(@ApiParam(value = "The ID of the specific order-food which you want edit.", required = true)
                                                 @PathVariable("id") final String id,
                                                 @ApiParam(value = "Order details details to update food in", required = true)
                                                 @Valid @RequestBody final OrdersFood ordersFood) {
        updateOrdersFoodHandler.handle(id, ordersFood);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
