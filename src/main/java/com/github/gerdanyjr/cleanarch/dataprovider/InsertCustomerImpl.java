package com.github.gerdanyjr.cleanarch.dataprovider;

import com.github.gerdanyjr.cleanarch.core.dataprovider.InsertCustomer;
import com.github.gerdanyjr.cleanarch.core.domain.Customer;
import com.github.gerdanyjr.cleanarch.dataprovider.repository.CustomerRepository;
import com.github.gerdanyjr.cleanarch.dataprovider.repository.entity.CustomerEntity;
import com.github.gerdanyjr.cleanarch.dataprovider.repository.mapper.CustomerEntityMapper;
import org.springframework.stereotype.Component;

@Component
public class InsertCustomerImpl implements InsertCustomer {

    private final CustomerRepository customerRepository;
    private final CustomerEntityMapper customerEntityMapper;

    public InsertCustomerImpl(CustomerRepository customerRepository, CustomerEntityMapper customerEntityMapper) {
        this.customerRepository = customerRepository;
        this.customerEntityMapper = customerEntityMapper;
    }

    @Override
    public void insert(Customer customer) {
        CustomerEntity customerEntity = customerEntityMapper.toEntity(customer);
        customerRepository.save(customerEntity);
    }
}
