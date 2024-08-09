package dev.neeraj.orderservice.controllers;

import dev.neeraj.orderservice.dtos.OrderAmountDTO;
import dev.neeraj.orderservice.dtos.ReceivedNewOrderDTO;
import dev.neeraj.orderservice.dtos.ReceivedOrderStatusDTO;
import dev.neeraj.orderservice.dtos.ReceivedProductDTO;
import dev.neeraj.orderservice.enums.OrderStatus;
import dev.neeraj.orderservice.exceptions.OrderNotFoundException;
import dev.neeraj.orderservice.models.Order;
import dev.neeraj.orderservice.models.OrderedItem;
import dev.neeraj.orderservice.services.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    IOrderService orderService;

    @PostMapping("/placeNewOrder")
    public ResponseEntity<Order> placeNewOrder(@RequestBody ReceivedNewOrderDTO receivedNewOrderDTO){

        List<OrderedItem> orderedItems = new ArrayList<>();

        for(ReceivedProductDTO receivedProductDTO: receivedNewOrderDTO.getReceivedProductDTOs()){
            OrderedItem orderedItem = new OrderedItem();
            orderedItem.setProductId(receivedProductDTO.getProductId());
            orderedItem.setQuantity(receivedProductDTO.getQuantity());
            orderedItem.setPrice(receivedProductDTO.getPrice());
            orderedItems.add(orderedItem);
        }
        Order placedOrder = orderService.createOrder(receivedNewOrderDTO.getUserId(), orderedItems);

        return ResponseEntity.ok(placedOrder);
    }

    @PostMapping("/updateOrderStatus")
    public ResponseEntity<Order> updateOrderStatus(@RequestBody ReceivedOrderStatusDTO receivedOrderStatusDTO)
            throws OrderNotFoundException {
        Order updatedOrder = orderService.updateOrderStatus(receivedOrderStatusDTO.getOrderId(),
                receivedOrderStatusDTO.getOrderStatus());
        return ResponseEntity.ok(updatedOrder);
    }

    @GetMapping("/getOrderAmount/{orderId}")
    public ResponseEntity<OrderAmountDTO> getOrderAmount(@PathVariable long orderId) throws OrderNotFoundException {
        return ResponseEntity.ok(orderService.getOrderAmount(orderId));
    }
}
