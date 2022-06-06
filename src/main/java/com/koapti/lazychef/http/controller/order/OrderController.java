package com.koapti.lazychef.http.controller.order;

import javax.validation.Valid;

import com.koapti.lazychef.api.model.Order;
import com.koapti.lazychef.api.model.OrderList;
import com.koapti.lazychef.http.HttpConstants;
import com.koapti.lazychef.http.exceptions.OrderNotFoundException;
import com.koapti.lazychef.http.handler.order.CreateOrderHandler;
import com.koapti.lazychef.http.handler.order.GetOrderDetailsHandler;
import com.koapti.lazychef.http.handler.order.GetOrdersHandler;
import com.koapti.lazychef.http.handler.order.UpdateOrderHandler;
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
@RequestMapping(HttpConstants.ORDER_HTTP_ENDPOINT)
public class OrderController {

    private CreateOrderHandler createOrderHandler;
    private GetOrderDetailsHandler getOrderDetailsHandler;
    private GetOrdersHandler getOrdersHandler;
    private UpdateOrderHandler updateOrderHandler;

    @ApiOperation(value = "", nickname = "getOrderDetails", notes = "Get order details", response = Order.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Order details", response = Order.class),
            @ApiResponse(code = 404, message = "Order with this id was not found.", response = String.class)})
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderDetails(@ApiParam(value = "The ID of the specific order for which you want details.", required = true)
                                                 @PathVariable("id") final String id) {
        try {
            Order order = getOrderDetailsHandler.handle(id);
            return new ResponseEntity<>(order, HttpStatus.OK);
        } catch (final OrderNotFoundException orderNotFoundException) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation(value = "", nickname = "createOrder", notes = "Create order", response = String.class)
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Order created successfully", response = String.class)})
    @PostMapping
    public ResponseEntity<String> createOrder(@ApiParam(value = "Order details to create", required = true) @Valid @RequestBody final Order order) {
        String id = createOrderHandler.handle(order);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    @ApiOperation(value = "", nickname = "getOrderList", notes = "Get order list", response = OrderList.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Order list", response = OrderList.class)})
    @GetMapping
    public ResponseEntity<OrderList> getOrderList() {
        return new ResponseEntity<>(getOrdersHandler.handle(), HttpStatus.OK);
    }

    @ApiOperation(value = "", nickname = "updateOrder", notes = "Update order")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Order updated successfully")})
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateOrder(@ApiParam(value = "The ID of the specific order which you want to edit.", required = true)
                                            @PathVariable("id") final String id, @ApiParam(value = "Order details to update", required = true)
                                            @Valid @RequestBody final Order order) {
        updateOrderHandler.handle(id, order);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
