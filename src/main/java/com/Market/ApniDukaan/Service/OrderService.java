package com.Market.ApniDukaan.Service;

import com.Market.ApniDukaan.Convertor.OrderedConvertor;
import com.Market.ApniDukaan.Enum.ProductStatus;
import com.Market.ApniDukaan.Exception.CustomerNotFoundException;
import com.Market.ApniDukaan.Exception.InsufficientQuantity;
import com.Market.ApniDukaan.Exception.ProductNotFoundException;
import com.Market.ApniDukaan.Model.*;
import com.Market.ApniDukaan.Repository.CustomerRepository;
import com.Market.ApniDukaan.Repository.ProductRepository;
import com.Market.ApniDukaan.RequestDTO.OrderRequestDto;
import com.Market.ApniDukaan.ResponseDTO.ItemResponseDto;
import com.Market.ApniDukaan.ResponseDTO.OrderResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ItemService itemService;
   @Autowired
    JavaMailSender emailSender;
    public OrderResponseDto placeOrder(OrderRequestDto orderRequestDto) throws CustomerNotFoundException, ProductNotFoundException, InsufficientQuantity {
        Customer customer;
        try{
            customer = customerRepository.findById(orderRequestDto.getCustomerId()).get();
        } catch (Exception e) {
            throw new CustomerNotFoundException("Invalid Customer id !!!!");
        }

        Product product;
        try {
            product = productRepository.findById(orderRequestDto.getProductId()).get();
        } catch (Exception e) {
            throw new ProductNotFoundException("Invalid Product Id !!!!!");
        }

        if(product.getQuantity()<orderRequestDto.getRequiredQuantity()){
            throw new InsufficientQuantity("Sorry !!!!! Required Quantity Not Available");
        }
        Ordered ordered = new Ordered();
        ordered.setTotalCost(orderRequestDto.getRequiredQuantity()*product.getPrice());
        ordered.setDeliveryCharge(40);

        Card card = customer.getCardList().get(0);
        String cardNo="";
        for(int i=0;i<card.getCardNo().length()-4;i++){
            cardNo+='x';
        }
        cardNo+=card.getCardNo().substring(card.getCardNo().length()-4);
        ordered.setCardUsedForPayment(cardNo);

        Item item = new Item();
        item.setRequiredQuantity(orderRequestDto.getRequiredQuantity());
        item.setProduct(product);
        item.setOrdered(ordered);
        ordered.getItemList().add(item);
        ordered.setCustomer(customer);

        customer.getOrderedList().add(ordered);
        Customer customersaved = customerRepository.save(customer);
        Ordered orderedsaved= customersaved.getOrderedList().get(customersaved.getOrderedList().size()-1);

        int leftQuantity = product.getQuantity()-orderRequestDto.getRequiredQuantity();
        if(leftQuantity<=0){
            product.setProductStatus(ProductStatus.OUT_OF_STOCK);
        }
        product.setQuantity(leftQuantity);

        OrderResponseDto orderResponseDto = OrderResponseDto.builder()
                .name(product.getName())
                .orderDate(ordered.getOrderDate())
                .itemPrice(product.getPrice())
                .quantityOrdered(orderRequestDto.getRequiredQuantity())
                .totalCost(ordered.getTotalCost())
                .deliveryCharge(40)
                .cardForPayment(cardNo)
                .build();

        // sends an email
        String text = "Congrats !!! Your order with total value  " + ordered.getTotalCost() + " has been placed";

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("email");
        message.setTo(customer.getEmail());
        message.setSubject("Order Placed Notification !!!");
        message.setText(text);
        emailSender.send(message);

        return orderResponseDto;

    }
}
