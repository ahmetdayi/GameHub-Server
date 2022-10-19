package com.software.gameHub.service;

import com.software.gameHub.dto.BasketDto;
import com.software.gameHub.dto.CreateBasketRequest;
import com.software.gameHub.dto.converter.BasketConverter;
import com.software.gameHub.entity.Basket;
import com.software.gameHub.repository.BasketDao;
import org.springframework.stereotype.Service;

@Service
public class BasketService {

    private final CustomerService customerService;
    private final BasketDao basketDao;
    private final BasketConverter basketConverter;

    public BasketService(CustomerService customerService, BasketDao basketDao, BasketConverter basketConverter) {
        this.customerService = customerService;
        this.basketDao = basketDao;
        this.basketConverter = basketConverter;
    }


    protected BasketDto create(CreateBasketRequest request){
        Basket basket = new Basket(request.getCustomer());
        return basketConverter.convert(basketDao.save(basket));
    }
}
