package com.Market.ApniDukaan.Convertor;

import com.Market.ApniDukaan.Enum.ProductStatus;
import com.Market.ApniDukaan.Model.Product;
import com.Market.ApniDukaan.RequestDTO.ProductRequestDto;
import com.Market.ApniDukaan.ResponseDTO.ProductResponseDto;

public class ProductConvertor {
    public static Product ProductRequestDtoToProduct(ProductRequestDto productRequestDto){
        return Product.builder()
                .name(productRequestDto.getName())
                .price(productRequestDto.getPrice())
                .quantity(productRequestDto.getQuantity())
                .productStatus(ProductStatus.AVAILABLE)
                .productCategory(productRequestDto.getProductCategory())
                .build();
    }
    public static ProductResponseDto ProductToProductResponseDto(Product product){
        return ProductResponseDto.builder()
                .name(product.getName())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .productStatus(product.getProductStatus())
                .build();
    }
}
