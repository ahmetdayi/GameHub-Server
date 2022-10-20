package com.software.gameHub.service;

import com.software.gameHub.core.constant.Constant;
import com.software.gameHub.core.exception.CustomerIdDoesNotExistException;
import com.software.gameHub.dto.CreateCustomerRequest;
import com.software.gameHub.dto.CustomerDto;
import com.software.gameHub.dto.converter.CustomerConverter;
import com.software.gameHub.entity.Basket;
import com.software.gameHub.entity.Customer;
import com.software.gameHub.entity.Library;
import com.software.gameHub.entity.Wallet;
import com.software.gameHub.repository.CustomerDao;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerDao customerDao;

    private final CustomerConverter customerConverter;

    public CustomerService(CustomerDao customerDao, CustomerConverter customerConverter) {
        this.customerDao = customerDao;
        this.customerConverter = customerConverter;
    }

    protected Customer findById(int customerId){
       return customerDao.findById(customerId).orElseThrow(
               ()->new CustomerIdDoesNotExistException(Constant.CUSTOMER_ID_DOES_NOT_EXIST));
    }

    public CustomerDto create(CreateCustomerRequest request){
        Library library = new Library();
        Wallet wallet = new Wallet();
        Basket basket = new Basket();

        Customer customer = new Customer
                (
                        request.getMail(),
                        request.getName(),
                        request.getSurname(),
                        request.getPassword(),
                        request.getPasswordMatch(),
                        library,
                        wallet,
                        basket

                );
        return customerConverter.convert(customerDao.save(customer));
    }

    public void delete(int customerId){
        customerDao.deleteById(findById(customerId).getCustomerId());
    }
}
