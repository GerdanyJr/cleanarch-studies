package com.github.gerdanyjr.cleanarch.core.usecase.impl;

import com.github.gerdanyjr.cleanarch.core.dataprovider.FindAddressByZipCode;
import com.github.gerdanyjr.cleanarch.core.dataprovider.InsertCustomer;
import com.github.gerdanyjr.cleanarch.core.dataprovider.SendCpfForValidation;
import com.github.gerdanyjr.cleanarch.core.domain.Address;
import com.github.gerdanyjr.cleanarch.core.domain.Customer;
import com.github.gerdanyjr.cleanarch.core.usecase.InsertCustomerUseCase;

public class InsertCustomerUseCaseImpl implements InsertCustomerUseCase {

    private final FindAddressByZipCode findAddressByZipCode;
    private final InsertCustomer insertCustomer;
    private final SendCpfForValidation sendCpfForValidation;

    public InsertCustomerUseCaseImpl(
            FindAddressByZipCode findAddressByZipCode,
            InsertCustomer insertCustomer,
            SendCpfForValidation sendCpfForValidation
    ) {
        this.findAddressByZipCode = findAddressByZipCode;
        this.insertCustomer = insertCustomer;
        this.sendCpfForValidation = sendCpfForValidation;
    }

    @Override
    public void insert(Customer customer, String zipcode) {
        Address address = findAddressByZipCode.find(zipcode);
        customer.setAddress(address);
        insertCustomer.insert(customer);
        sendCpfForValidation.send(customer.getCpf());
    }

}
