package com.Market.ApniDukaan.Convertor;

import com.Market.ApniDukaan.Model.Seller;
import com.Market.ApniDukaan.RequestDTO.SellerRequestDto;

public class SellerConvertor {
    public static Seller SellerRequestDtoToSeller(SellerRequestDto sellerRequestDto){
        return Seller.builder()
                .name(sellerRequestDto.getName())
                .email(sellerRequestDto.getEmail())
                .mobNo(sellerRequestDto.getMobNo())
                .panNo(sellerRequestDto.getPanNo())
                .build();
    }
}
