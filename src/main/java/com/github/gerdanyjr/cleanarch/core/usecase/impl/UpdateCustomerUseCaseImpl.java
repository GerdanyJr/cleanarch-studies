package com.github.gerdanyjr.cleanarch.core.usecase.impl;

import com.github.gerdanyjr.cleanarch.core.dataprovider.FindAddressByZipCode;
import com.github.gerdanyjr.cleanarch.core.dataprovider.UpdateCustomer;
import com.github.gerdanyjr.cleanarch.core.domain.Address;
import com.github.gerdanyjr.cleanarch.core.domain.Customer;
import com.github.gerdanyjr.cleanarch.core.usecase.FindCustomerByIdUseCase;
import com.github.gerdanyjr.cleanarch.core.usecase.UpdateCustomerUseCase;

public class UpdateCustomerUseCaseImpl implements UpdateCustomerUseCase {

    private final FindCustomerByIdUseCase findCustomerByIdUseCase;
    private final FindAddressByZipCode findAddressByZipCode;
    private final UpdateCustomer updateCustomer;

    public UpdateCustomerUseCaseImpl(
            FindCustomerByIdUseCase findCustomerByIdUseCase,
            FindAddressByZipCode findAddressByZipCode, UpdateCustomer updateCustomer
    ) {
        this.findCustomerByIdUseCase = findCustomerByIdUseCase;
        this.findAddressByZipCode = findAddressByZipCode;
        this.updateCustomer = updateCustomer;
    }

    @Override
    public void update(Customer customer, String zipcode) {
        findCustomerByIdUseCase.find(customer.getId());

        Address address = findAddressByZipCode.find(zipcode);
        customer.setAddress(address);

        updateCustomer.update(customer);
    }

}
