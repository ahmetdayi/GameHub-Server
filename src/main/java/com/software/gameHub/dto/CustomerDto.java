package com.software.gameHub.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

    private int customerId;

    private String mail;

    private String surname;

    private LibraryDto library;

    private WalletDto wallet;

    private BasketDto basket;




}
