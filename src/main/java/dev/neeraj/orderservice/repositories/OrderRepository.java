package dev.neeraj.orderservice.repositories;

import dev.neeraj.orderservice.models.Order;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Order save(Order order);
    Order findById(long orderId);
}
