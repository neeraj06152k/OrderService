package dev.neeraj.orderservice.services;

import dev.neeraj.orderservice.enums.OrderStatus;
import dev.neeraj.orderservice.exceptions.OrderNotFoundException;
import dev.neeraj.orderservice.models.Order;
import dev.neeraj.orderservice.models.OrderedItem;
import dev.neeraj.orderservice.repositories.OrderRepository;
import dev.neeraj.orderservice.repositories.OrderedItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Primary
public class OrderService implements IOrderService{

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderedItemRepository orderedItemRepository;

    @Override
    public Order createOrder(long userId, List<OrderedItem> orderedItems) {
        Order newOrder = new Order();
        newOrder.setUserId(userId);
        newOrder.setOrderStatus(OrderStatus.PENDINGPAYMENT);

        List<OrderedItem> finalOrderedItems = new ArrayList<>();
        for (OrderedItem orderedItem : orderedItems) {
            OrderedItem existingOrderItem =
                    orderedItemRepository.findByProductId(orderedItem.getProductId());
            if(existingOrderItem==null)
                finalOrderedItems.add(orderedItemRepository.save(orderedItem));
            else finalOrderedItems.add(existingOrderItem);
        }

        newOrder.setOrderedItems(finalOrderedItems);

        newOrder = orderRepository.save(newOrder);

        return newOrder;
    }

    @Override
    public Order getOrder(long orderId) throws OrderNotFoundException {
        Order savedOrder = orderRepository.findById(orderId);

        if(savedOrder==null)
            throw new OrderNotFoundException("Order with ID " +
                    orderId +
                    "%d not found");

        return savedOrder;
    }

    public Order updateOrderStatus(long orderId, OrderStatus newOrderStatus)
            throws OrderNotFoundException {
        Order order = getOrder(orderId);
        order.setOrderStatus(newOrderStatus);

        return orderRepository.save(order);
    }
}
