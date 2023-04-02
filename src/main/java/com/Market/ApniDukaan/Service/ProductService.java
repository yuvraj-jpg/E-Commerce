package com.Market.ApniDukaan.Service;

import com.Market.ApniDukaan.Convertor.ProductConvertor;
import com.Market.ApniDukaan.Enum.ProductCategory;
import com.Market.ApniDukaan.Exception.SellerNotFoundException;
import com.Market.ApniDukaan.Model.Product;
import com.Market.ApniDukaan.Model.Seller;
import com.Market.ApniDukaan.Repository.ProductRepository;
import com.Market.ApniDukaan.Repository.SellerRepository;
import com.Market.ApniDukaan.RequestDTO.ProductRequestDto;
import com.Market.ApniDukaan.ResponseDTO.ProductResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    SellerRepository sellerRepository;

    public ProductResponseDto addProduct(ProductRequestDto productRequestDto) throws SellerNotFoundException{
        Seller seller;
        try {
            seller = sellerRepository.findById(productRequestDto.getSellerId()).get();
        } catch (Exception e) {
            throw new SellerNotFoundException("Invalid Seller Id");
        }
        Product product  = ProductConvertor.ProductRequestDtoToProduct(productRequestDto);
        product.setSeller(seller);
        seller.getProductList().add(product);
        sellerRepository.save(seller);
        ProductResponseDto productResponseDto = ProductConvertor.ProductToProductResponseDto(product);
        productRepository.save(product);
        return productResponseDto;
    }
    public List<ProductResponseDto> getAllProductByCategory(ProductCategory productCategory){
        List<Product> productList = productRepository.findAllByProductCategory(productCategory);
        List<ProductResponseDto> productResponseDtoList = new ArrayList<>();
        for(Product product : productList){
            productResponseDtoList.add(ProductConvertor.ProductToProductResponseDto(product));
        }
        return productResponseDtoList;
    }
}
