package com.software.gameHub.service;

import com.software.gameHub.core.constant.Constant;
import com.software.gameHub.core.exception.GameAlreadyExistsInBasketException;
import com.software.gameHub.core.exception.GameIdDoesNotExistException;
import com.software.gameHub.entity.dto.AddGameToBasketRequest;
import com.software.gameHub.entity.dto.CreateGameRequest;
import com.software.gameHub.entity.dto.GameDto;
import com.software.gameHub.entity.dto.converter.GameConverter;
import com.software.gameHub.entity.Basket;
import com.software.gameHub.entity.Category;
import com.software.gameHub.entity.Game;
import com.software.gameHub.repository.GameDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    private final GameDao gameDao;

    private final CustomerService customerService;

    private final CategoryService categoryService;

    private final GameConverter gameConverter;

    public GameService(GameDao gameDao, CustomerService customerService, CategoryService categoryService, GameConverter gameConverter) {
        this.gameDao = gameDao;
        this.customerService = customerService;
        this.categoryService = categoryService;
        this.gameConverter = gameConverter;
    }

    public GameDto createGame(CreateGameRequest request){

        List<Category> categories = request.getCategoryIds().stream().map(categoryService::findById).toList();
        Game game = new Game
                (
                        request.getName(),
                        request.getPrice(),
                        categories
                );

        return gameConverter.convert(gameDao.save(game));
    }

    public void delete(int gameId){
        gameDao.deleteById(findById(gameId).getGameId());
    }

    protected Game findById(int gameId){
        return gameDao.findById(gameId).orElseThrow(()-> new GameIdDoesNotExistException(Constant.GAME_ID_DOES_NOT_EXIST));
    }

    public List<Game> addGameToBasket(AddGameToBasketRequest request){

        Basket basket = customerService.findById(request.getCustomerId()).getBasket();
        Game game = findById(request.getGameId());
        List<Game> collect = customerService.findById(request.getCustomerId()).getBasket().getGames().stream()
                .filter(game1 -> game1.equals(game)).toList();

        if(collect.get(0) != null){
            throw new GameAlreadyExistsInBasketException(Constant.GAME_ALREADY_EXISTS_IN_BASKET);
        }
        basket.getGames().add(game);
        return basket.getGames();
    }
}
