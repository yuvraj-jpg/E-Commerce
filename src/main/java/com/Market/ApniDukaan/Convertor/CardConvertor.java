package com.Market.ApniDukaan.Convertor;

import com.Market.ApniDukaan.Model.Card;
import com.Market.ApniDukaan.RequestDTO.CardRequestDto;
import com.Market.ApniDukaan.ResponseDTO.CardResponseDto;

public class CardConvertor {

    public static Card CardRequestDtoToCard(CardRequestDto cardRequestDto){
        return Card.builder()
                .cardNo(cardRequestDto.getCardNo())
                .cvv(cardRequestDto.getCvv())
                .cardType(cardRequestDto.getCardType())
                .build();
    }
    public static CardResponseDto CardToCardResponseDto(Card card){
        return CardResponseDto.builder().build();
    }
}
