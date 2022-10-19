package com.software.gameHub.dto.converter;

import com.software.gameHub.dto.BuyDto;
import com.software.gameHub.entity.Buy;
import org.springframework.stereotype.Component;

@Component
public class BuyConverter {

    private final GameConverter gameConverter;

    public BuyConverter(GameConverter gameConverter) {
        this.gameConverter = gameConverter;
    }

    public BuyDto convert(Buy from){
        return new BuyDto(from.getBuyId(), gameConverter.convert(from.getGame()));
    }
}
