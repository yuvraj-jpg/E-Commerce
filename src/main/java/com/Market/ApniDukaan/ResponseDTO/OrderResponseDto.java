package com.Market.ApniDukaan.ResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponseDto {
    private String name;
    private Date orderDate;
    private int itemPrice;
    private int quantityOrdered;
    private int totalCost;
    private int deliveryCharge;
    private String cardForPayment;
}
