package com.Market.ApniDukaan.RequestDTO;

import com.Market.ApniDukaan.Enum.ProductCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequestDto {
    private int sellerId;
    private String name;
    private int price;
    private int quantity;
    private ProductCategory productCategory;

}
