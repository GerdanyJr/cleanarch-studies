package com.github.gerdanyjr.cleanarch.dataprovider;

import com.github.gerdanyjr.cleanarch.core.dataprovider.FindCustomerById;
import com.github.gerdanyjr.cleanarch.core.domain.Customer;
import com.github.gerdanyjr.cleanarch.dataprovider.repository.CustomerRepository;
import com.github.gerdanyjr.cleanarch.dataprovider.repository.entity.CustomerEntity;
import com.github.gerdanyjr.cleanarch.dataprovider.repository.mapper.CustomerEntityMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindCustomerByIdImpl implements FindCustomerById {

    private final CustomerRepository customerRepository;
    private final CustomerEntityMapper customerEntityMapper;

    public FindCustomerByIdImpl(CustomerRepository customerRepository, CustomerEntityMapper customerEntityMapper) {
        this.customerRepository = customerRepository;
        this.customerEntityMapper = customerEntityMapper;
    }

    @Override
    public Optional<Customer> find(String id) {
        Optional<CustomerEntity> customerEntity = customerRepository
                .findById(id);
        return customerEntity.map(customerEntityMapper::toCustomer);
    }

}
