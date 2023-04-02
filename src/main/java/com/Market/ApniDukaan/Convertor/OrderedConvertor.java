package com.Market.ApniDukaan.Convertor;

import com.Market.ApniDukaan.Model.Customer;
import com.Market.ApniDukaan.Model.Ordered;
import com.Market.ApniDukaan.Model.Product;
import com.Market.ApniDukaan.RequestDTO.OrderRequestDto;

public class OrderedConvertor {
    public static Ordered OrderRequestDtoToOrdered(OrderRequestDto orderRequestDto, Product product, Customer customer){
        int totalCost=orderRequestDto.getRequiredQuantity()*product.getPrice();
        int delivary=0;
        if(totalCost<500){
            delivary = 50;
            totalCost+=delivary;
        }
        return Ordered.builder()
                .totalCost(orderRequestDto.getRequiredQuantity()*product.getPrice())
                .deliveryCharge(delivary)
                .customer(customer)
                .build();
    }
}
