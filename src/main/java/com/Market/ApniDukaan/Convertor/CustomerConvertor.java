package com.Market.ApniDukaan.Convertor;


import com.Market.ApniDukaan.Model.Customer;
import com.Market.ApniDukaan.RequestDTO.CustomerRequestDto;

public class CustomerConvertor {
    public static Customer CustomerRequestDtotoCustomer(CustomerRequestDto customerRequestDto){
        return Customer.builder()
                .name(customerRequestDto.getName())
                .age(customerRequestDto.getAge())
                .email(customerRequestDto.getEmail())
                .mobNo(customerRequestDto.getMobNo())
                .build();
    }

}
