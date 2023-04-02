package com.Market.ApniDukaan.Service;

import com.Market.ApniDukaan.Convertor.ItemConvertor;
import com.Market.ApniDukaan.Exception.ProductNotFoundException;
import com.Market.ApniDukaan.Model.Item;
import com.Market.ApniDukaan.Model.Product;
import com.Market.ApniDukaan.Repository.ProductRepository;
import com.Market.ApniDukaan.ResponseDTO.ItemResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    @Autowired
    ProductRepository productRepository;
    public ItemResponseDto viewItem(int productId) throws ProductNotFoundException {
        Product product;
        try{
            product = productRepository.findById(productId).get();
        } catch (Exception e) {
            throw new ProductNotFoundException("Sorry Invalid product Id");
        }
        Item item = Item.builder()
                .requiredQuantity(0)
                .product(product)
                .build();
        product.setItem(item);
        productRepository.save(product);

        ItemResponseDto itemResponseDto = ItemConvertor.ProductToItemResponseDto(product);
        return itemResponseDto;
    }
}
