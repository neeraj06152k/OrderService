package dev.neeraj.orderservice.dtos;

import dev.neeraj.orderservice.enums.OrderStatus;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReceivedOrderStatusDTO {
    private long orderId;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
}
