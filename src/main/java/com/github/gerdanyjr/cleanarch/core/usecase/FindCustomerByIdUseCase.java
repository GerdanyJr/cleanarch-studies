package com.github.gerdanyjr.cleanarch.core.usecase;

import com.github.gerdanyjr.cleanarch.core.domain.Customer;

public interface FindCustomerByIdUseCase {
    Customer find(String id);
}
