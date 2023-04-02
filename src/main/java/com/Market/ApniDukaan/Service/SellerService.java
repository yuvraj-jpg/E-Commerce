package com.Market.ApniDukaan.Service;

import com.Market.ApniDukaan.Convertor.SellerConvertor;
import com.Market.ApniDukaan.Model.Seller;
import com.Market.ApniDukaan.Repository.SellerRepository;
import com.Market.ApniDukaan.RequestDTO.SellerRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SellerService {
    @Autowired
    SellerRepository sellerRepository;
    public String addSeller(SellerRequestDto sellerRequestDto){
        Seller seller = SellerConvertor.SellerRequestDtoToSeller(sellerRequestDto);
        sellerRepository.save(seller);
        return "Congrats! Now You Can Sell On Apna-Dukaan !!!";
    }
    public List<Seller> getAllSeller(){
        List<Seller> sellers = sellerRepository.findAll();
         return sellers;
    }
}
