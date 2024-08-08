package dev.neeraj.orderservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReceivedUserProductDTO {
    private long productId;
    private long userId;
}
