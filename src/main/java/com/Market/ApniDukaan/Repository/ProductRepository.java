package com.Market.ApniDukaan.Repository;

import com.Market.ApniDukaan.Enum.ProductCategory;
import com.Market.ApniDukaan.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    List<Product> findAllByProductCategory(ProductCategory productCategory);
}
