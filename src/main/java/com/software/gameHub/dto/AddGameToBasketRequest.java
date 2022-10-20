package com.software.gameHub.dto;

import lombok.Data;

@Data
public class AddGameToBasketRequest {

    private int customerId;

    private int gameId;
}
