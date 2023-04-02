package com.Market.ApniDukaan.Controller;

import com.Market.ApniDukaan.Exception.ProductNotFoundException;
import com.Market.ApniDukaan.Model.Product;
import com.Market.ApniDukaan.ResponseDTO.ItemResponseDto;
import com.Market.ApniDukaan.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    ItemService itemService;
    @GetMapping("/view/{productId}")
    public ResponseEntity viewItem(@PathVariable("productId") int productId){
        ItemResponseDto itemResponseDto;
        try {
            itemResponseDto = itemService.viewItem(productId);

        } catch (ProductNotFoundException e) {
            return new ResponseEntity(e.getMessage(),HttpStatus.ACCEPTED);
        }
        return new ResponseEntity(itemResponseDto,HttpStatus.ACCEPTED);
    }

}
