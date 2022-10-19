package com.software.gameHub.service;

import com.software.gameHub.core.constant.Constant;
import com.software.gameHub.core.exception.CustomerIdDoesNotExistException;
import com.software.gameHub.entity.Customer;
import com.software.gameHub.repository.CustomerDao;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerDao customerDao;

    public CustomerService(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    protected Customer findById(int customerId){
       return customerDao.findById(customerId).orElseThrow(
               ()->new CustomerIdDoesNotExistException(Constant.CUSTOMER_ID_DOES_NOT_EXIST));


    }
}
