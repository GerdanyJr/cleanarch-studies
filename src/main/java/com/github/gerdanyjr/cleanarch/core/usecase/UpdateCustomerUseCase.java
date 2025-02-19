package com.github.gerdanyjr.cleanarch.core.usecase;

import com.github.gerdanyjr.cleanarch.core.domain.Customer;

public interface UpdateCustomerUseCase {

    void update(Customer customer, String zipcode);

}
