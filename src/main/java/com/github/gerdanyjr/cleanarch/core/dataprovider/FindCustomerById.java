package com.github.gerdanyjr.cleanarch.core.dataprovider;

import com.github.gerdanyjr.cleanarch.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerById {

    Optional<Customer> find(String id);

}
