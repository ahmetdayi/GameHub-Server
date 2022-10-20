package com.software.gameHub.dto;

import lombok.Data;

@Data
public class AddBalanceRequest {

    private int walletId;

    private double balance;
}
