package com.software.gameHub.service;

import com.software.gameHub.entity.dto.BuyDto;
import com.software.gameHub.entity.dto.CreateBuyRequest;
import com.software.gameHub.entity.dto.converter.BuyConverter;
import com.software.gameHub.entity.Buy;
import com.software.gameHub.entity.Customer;
import com.software.gameHub.entity.Game;
import com.software.gameHub.repository.BuyDao;
import org.springframework.stereotype.Service;

@Service
public class BuyService {

    private final BuyDao buyDao;

    private final CustomerService customerService;

    private final GameService gameService;

    private final BuyConverter buyConverter;

    public BuyService(BuyDao buyDao, CustomerService customerService, GameService gameService, BuyConverter buyConverter) {
        this.buyDao = buyDao;
        this.customerService = customerService;
        this.gameService = gameService;
        this.buyConverter = buyConverter;
    }

    public BuyDto buy(CreateBuyRequest request){

        Customer customer = customerService.findById(request.getCustomerId());
        Game game = gameService.findById(request.getGameId());


        Buy buy = new Buy
                (
                        customer,
                        game,
                        customer.getLibrary()
                );

        return buyConverter.convert(buyDao.save(buy));
    }
}
