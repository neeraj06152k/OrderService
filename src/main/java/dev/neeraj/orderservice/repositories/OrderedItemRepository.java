package dev.neeraj.orderservice.repositories;

import dev.neeraj.orderservice.models.OrderedItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderedItemRepository extends JpaRepository<OrderedItem, Long> {
    OrderedItem findByProductId(long productId);
    OrderedItem save(OrderedItem orderedItem);
    List<OrderedItem> findAllByOrdersId(long orderId);
}
