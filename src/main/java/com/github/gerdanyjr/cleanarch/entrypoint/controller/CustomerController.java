package com.github.gerdanyjr.cleanarch.entrypoint.controller;

import com.github.gerdanyjr.cleanarch.core.domain.Customer;
import com.github.gerdanyjr.cleanarch.core.usecase.InsertCustomerUseCase;
import com.github.gerdanyjr.cleanarch.entrypoint.controller.mapper.CustomerMapper;
import com.github.gerdanyjr.cleanarch.entrypoint.controller.request.CustomerRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final InsertCustomerUseCase insertCustomerUseCase;
    private final CustomerMapper customerMapper;

    public CustomerController(InsertCustomerUseCase insertCustomerUseCase, CustomerMapper customerMapper) {
        this.insertCustomerUseCase = insertCustomerUseCase;
        this.customerMapper = customerMapper;
    }

    @PostMapping
    public ResponseEntity<Void> insert(
            @RequestBody @Valid CustomerRequest customerRequest
    ) {
        Customer customer = customerMapper.toCustomer(customerRequest);
        insertCustomerUseCase.insert(customer, customerRequest.getZipcode());
        return ResponseEntity.ok().build();
    }
}
