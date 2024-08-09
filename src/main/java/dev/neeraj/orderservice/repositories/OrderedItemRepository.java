package dev.neeraj.orderservice.repositories;

import dev.neeraj.orderservice.dtos.OrderAmountDTO;
import dev.neeraj.orderservice.models.OrderedItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderedItemRepository extends JpaRepository<OrderedItem, Long> {
    OrderedItem findByProductId(long productId);
    OrderedItem save(OrderedItem orderedItem);
    List<OrderedItem> findAllByOrderId(long orderId);
}
