package com.software.gameHub.service;

import com.software.gameHub.dto.CreateGameRequest;
import com.software.gameHub.dto.GameDto;
import com.software.gameHub.repository.GameDao;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    private final GameDao gameDao;

    public GameService(GameDao gameDao) {
        this.gameDao = gameDao;
    }

    public GameDto createGame(CreateGameRequest request){


        return null;
    }
}
