package com.Market.ApniDukaan.ResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CardResponseDto {
    private String name;
    private List<CardDto> cardDtos;
}
