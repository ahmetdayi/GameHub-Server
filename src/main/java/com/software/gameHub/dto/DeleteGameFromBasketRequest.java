package com.software.gameHub.dto;

import lombok.Data;

@Data
public class DeleteGameFromBasketRequest {

    private int customerId;

    private int gameId;
}
