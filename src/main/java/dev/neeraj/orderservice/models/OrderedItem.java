package dev.neeraj.orderservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class OrderedItem extends BaseModel{

    @Column(nullable = false)
    private long productId;
    @Column(nullable = false)
    private int quantity;
    @Column(nullable = false)
    private long price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;


}
