package com.software.gameHub.entity.dto.converter;

import com.software.gameHub.entity.dto.BasketDto;
import com.software.gameHub.entity.Basket;
import org.springframework.stereotype.Component;

@Component
public class BasketConverter {


    private final BasketGameDtoConverter basketGameDtoConverter;

    public BasketConverter( BasketGameDtoConverter basketGameDtoConverter) {

        this.basketGameDtoConverter = basketGameDtoConverter;
    }

    public BasketDto convert(Basket from){
        if (from == null){
            return null;
        }
        return new BasketDto(from.getBasketId(),
                basketGameDtoConverter.converter(from.getGames()));
    }
}
