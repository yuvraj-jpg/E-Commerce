package com.Market.ApniDukaan.Convertor;

import com.Market.ApniDukaan.Model.Product;
import com.Market.ApniDukaan.ResponseDTO.ItemResponseDto;

public class ItemConvertor {

    public static ItemResponseDto ProductToItemResponseDto(Product product){
        return ItemResponseDto.builder()
                .name(product.getName())
                .price(product.getPrice())
                .productCategory(product.getProductCategory())
                .productStatus(product.getProductStatus())
                .build();
    }
}
