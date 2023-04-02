package com.Market.ApniDukaan.ResponseDTO;

import com.Market.ApniDukaan.Enum.ProductCategory;
import com.Market.ApniDukaan.Enum.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemResponseDto {
    private String name;
    private int price;
    private ProductCategory productCategory;
    private ProductStatus productStatus;

}
