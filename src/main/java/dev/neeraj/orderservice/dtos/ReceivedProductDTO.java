package dev.neeraj.orderservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReceivedProductDTO {
    private long productId;
    private int quantity;
    private long price;
}
