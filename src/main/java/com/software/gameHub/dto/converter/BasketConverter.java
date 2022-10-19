package com.software.gameHub.dto.converter;

import com.software.gameHub.dto.BasketDto;
import com.software.gameHub.entity.Basket;
import org.springframework.stereotype.Component;

@Component
public class BasketConverter {

    private final GameConverter gameConverter;

    public BasketConverter(GameConverter gameConverter) {
        this.gameConverter = gameConverter;
    }

    public BasketDto convert(Basket from){
        return new BasketDto(from.getBasketId(),
                gameConverter.convert(from.getGames()));
    }
}
