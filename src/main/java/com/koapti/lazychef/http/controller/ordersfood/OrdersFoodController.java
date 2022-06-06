package com.koapti.lazychef.http.controller.ordersfood;

import javax.validation.Valid;

import com.koapti.lazychef.api.model.OrdersFood;
import com.koapti.lazychef.api.model.OrdersFoodList;
import com.koapti.lazychef.http.HttpConstants;
import com.koapti.lazychef.http.handler.ordersfood.CreateOrdersFoodHandler;
import com.koapti.lazychef.http.handler.ordersfood.GetOrdersFoodHandler;
import com.koapti.lazychef.http.handler.ordersfood.UpdateOrdersFoodHandler;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping(HttpConstants.ORDERS_FOOD_HTTP_ENDPOINT)
public class OrdersFoodController {

    private CreateOrdersFoodHandler createOrdersFoodHandler;
    private GetOrdersFoodHandler getOrdersFoodHandler;
    private UpdateOrdersFoodHandler updateOrdersFoodHandler;

    @ApiOperation(value = "", nickname = "createOrdersFood", notes = "Create orders-food connection", response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OrdersFood created successfully", response = String.class)})
    @PostMapping
    public ResponseEntity<String> createOrdersFood(@ApiParam(value = "Orders-food connection details.", required = true)
                                                   @Valid @RequestBody final OrdersFood ordersFood) {
        String id = createOrdersFoodHandler.handle(ordersFood);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @ApiOperation(value = "", nickname = "getOrdersFoodList", notes = "Get list of orders-food connections", response = OrdersFoodList.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Order list", response = OrdersFoodList.class)})
    @GetMapping
    public ResponseEntity<OrdersFoodList> getOrdersFoodList() {
        return new ResponseEntity<>(getOrdersFoodHandler.handle(), HttpStatus.OK);
    }

    @ApiOperation(value = "", nickname = "updateOrdersFood", notes = "Update food in order")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OrdersFood updated successfully"),
            @ApiResponse(code = 404, message = "OrdersFood with this id was not found.", response = String.class)})
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateOrdersFood(@ApiParam(value = "The ID of the specific order-food which you want edit.", required = true)
                                                 @PathVariable("id") final String id,
                                                 @ApiParam(value = "Order details details to update food in", required = true)
                                                 @Valid @RequestBody final OrdersFood ordersFood) {
        updateOrdersFoodHandler.handle(id, ordersFood);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
