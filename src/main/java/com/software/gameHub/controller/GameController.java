package com.software.gameHub.controller;


import com.software.gameHub.entity.dto.AddGameToBasketRequest;
import com.software.gameHub.entity.dto.CreateGameRequest;
import com.software.gameHub.entity.dto.GameDto;

import com.software.gameHub.entity.Game;
import com.software.gameHub.service.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/game")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/create")
    public ResponseEntity<GameDto> createGame( @RequestBody CreateGameRequest request){
        return new ResponseEntity<>(gameService.createGame(request), HttpStatus.CREATED);
    }

    @DeleteMapping("/gameId")
    public ResponseEntity<Void> delete(@RequestParam int gameId){
        gameService.delete(gameId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<List<Game>> addGameToBasket(@Valid @RequestBody AddGameToBasketRequest request){
        return new ResponseEntity<>(gameService.addGameToBasket(request),HttpStatus.OK);

    }
}
