package dev.neeraj.orderservice.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class OrderedItem extends BaseModel{

    @Column(unique = true, nullable = false)
    private long productId;

    @ManyToMany(mappedBy = "orderedItems", fetch = FetchType.LAZY)
    private List<Order> orders;


}
