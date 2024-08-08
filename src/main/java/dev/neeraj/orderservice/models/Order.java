package dev.neeraj.orderservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.neeraj.orderservice.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "orders")
public class Order extends BaseModel{

    @Column(nullable = false)
    private long userId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderStatus orderStatus;

    @JsonIgnore
    @ManyToMany(targetEntity = OrderedItem.class,
            fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST)
    private List<OrderedItem> orderedItems;
}