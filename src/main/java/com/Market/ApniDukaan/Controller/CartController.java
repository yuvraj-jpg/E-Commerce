package com.Market.ApniDukaan.Controller;

import com.Market.ApniDukaan.Exception.CustomerNotFoundException;
import com.Market.ApniDukaan.Exception.InsufficientQuantity;
import com.Market.ApniDukaan.Exception.ProductNotFoundException;
import com.Market.ApniDukaan.RequestDTO.OrderRequestDto;
import com.Market.ApniDukaan.ResponseDTO.OrderResponseDto;
import com.Market.ApniDukaan.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @PostMapping("/add")
    public String addToCart(@RequestBody OrderRequestDto orderRequestDto){
        String response ="";
        try{
            response = cartService.addToCart(orderRequestDto);
        } catch (Exception e) {
            return e.getMessage();
        }

        return response;

    }

    @PostMapping("/checkout/{customerId}")
    public ResponseEntity checkoutCart(@PathVariable("customerId") int customerId){
        List<OrderResponseDto> list;
        try {
            list = cartService.checkoutCart(customerId);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(list,HttpStatus.ACCEPTED);

    }
}
