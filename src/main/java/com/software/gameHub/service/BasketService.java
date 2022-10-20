package com.software.gameHub.service;

import com.software.gameHub.core.constant.Constant;
import com.software.gameHub.core.exception.GameIdDoesNotExistException;
import com.software.gameHub.entity.dto.DeleteGameFromBasketRequest;
import com.software.gameHub.entity.Buy;
import com.software.gameHub.entity.Customer;
import com.software.gameHub.entity.Game;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BasketService {

    private final CustomerService customerService;

    private final GameService gameService;

    public BasketService( CustomerService customerService, GameService gameService) {
        this.customerService = customerService;
        this.gameService = gameService;
    }

    public List<Game> deleteGameFromBasket(DeleteGameFromBasketRequest request ){
        Game game = gameService.findById(request.getGameId());
        Customer customer = customerService.findById(request.getCustomerId());
        List<Game> collect = customer.getBasket().getGames().stream()
                .filter(game1 -> game1.equals(game)).toList();

        if(collect.get(0) == null){
            throw new GameIdDoesNotExistException(Constant.GAME_ID_DOES_NOT_EXIST);
        }
        else{
             customer.getBasket().getGames().remove(game);
             return customer.getBasket().getGames();
        }


    }

    public List<Buy> buyGameFromBasket(int customerId){
        Customer customer = customerService.findById(customerId);

        List<Game> games = customer.getBasket().getGames();

        return  games.stream().map(game -> new Buy(customer, game, customer.getLibrary())).collect(Collectors.toList());

    }
}
