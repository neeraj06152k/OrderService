package dev.neeraj.orderservice.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ReceivedNewOrderDTO {
    private long userId;
    private List<ReceivedProductDTO> receivedProductDTOs;
}
