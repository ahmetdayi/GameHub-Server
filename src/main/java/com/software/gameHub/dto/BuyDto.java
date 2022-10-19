package com.software.gameHub.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BuyDto {

    private int buyId;

    private GameDto game;
}
