package com.github.gerdanyjr.cleanarch.core.usecase;

import com.github.gerdanyjr.cleanarch.core.domain.Customer;

public interface InsertCustomerUseCase {

    void insert(Customer customer, String zipcode);

}
