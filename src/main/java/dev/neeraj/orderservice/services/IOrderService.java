package dev.neeraj.orderservice.services;

import dev.neeraj.orderservice.dtos.OrderAmountDTO;
import dev.neeraj.orderservice.dtos.ReceivedUserProductDTO;
import dev.neeraj.orderservice.enums.OrderStatus;
import dev.neeraj.orderservice.exceptions.OrderNotFoundException;
import dev.neeraj.orderservice.models.Order;
import dev.neeraj.orderservice.models.OrderedItem;

import java.util.List;

public interface IOrderService {
    Order createOrder(long userId, List<OrderedItem> orderedItems);
    Order getOrder(long orderId) throws OrderNotFoundException;
    Order updateOrderStatus(long orderId, OrderStatus newOrderStatus) throws OrderNotFoundException;
    OrderAmountDTO getOrderAmount(long orderId) throws OrderNotFoundException;

}
