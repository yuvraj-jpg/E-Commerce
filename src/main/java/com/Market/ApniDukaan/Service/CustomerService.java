package com.Market.ApniDukaan.Service;

import com.Market.ApniDukaan.Convertor.CustomerConvertor;
import com.Market.ApniDukaan.Model.Cart;
import com.Market.ApniDukaan.Model.Customer;
import com.Market.ApniDukaan.Repository.CustomerRepository;
import com.Market.ApniDukaan.RequestDTO.CustomerRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    public String addCustomer(CustomerRequestDto customerRequestDto){
        Customer customer = CustomerConvertor.CustomerRequestDtotoCustomer(customerRequestDto);
        Cart cart = new Cart();
        cart.setCartTotal(0);
        cart.setCustomer(customer);

        customer.setCart(cart);
        customerRepository.save(customer);
        return "Congrats !!! Welcome to Apni Dukaan !!!.";
    }
}
