package com.github.gerdanyjr.cleanarch.dataprovider;

import com.github.gerdanyjr.cleanarch.core.dataprovider.DeleteCustomerById;
import com.github.gerdanyjr.cleanarch.dataprovider.repository.CustomerRepository;
import org.springframework.stereotype.Component;

@Component
public class DeleteCustomerByIdImpl implements DeleteCustomerById {

    private final CustomerRepository customerRepository;

    public DeleteCustomerByIdImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void delete(String id) {
        customerRepository.deleteById(id);
    }
}
