package com.software.gameHub.entity.dto;

import lombok.Data;

@Data
public class DeleteGameFromBasketRequest {

    private int customerId;

    private int gameId;
}
