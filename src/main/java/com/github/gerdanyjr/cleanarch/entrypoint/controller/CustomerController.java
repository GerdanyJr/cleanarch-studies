package com.github.gerdanyjr.cleanarch.entrypoint.controller;

import com.github.gerdanyjr.cleanarch.core.dataprovider.DeleteCustomerById;
import com.github.gerdanyjr.cleanarch.core.domain.Customer;
import com.github.gerdanyjr.cleanarch.core.usecase.DeleteCustomerByIdUseCase;
import com.github.gerdanyjr.cleanarch.core.usecase.FindCustomerByIdUseCase;
import com.github.gerdanyjr.cleanarch.core.usecase.InsertCustomerUseCase;
import com.github.gerdanyjr.cleanarch.core.usecase.UpdateCustomerUseCase;
import com.github.gerdanyjr.cleanarch.entrypoint.controller.mapper.CustomerMapper;
import com.github.gerdanyjr.cleanarch.entrypoint.controller.request.CustomerRequest;
import com.github.gerdanyjr.cleanarch.entrypoint.controller.response.CustomerResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerMapper customerMapper;
    private final InsertCustomerUseCase insertCustomerUseCase;
    private final FindCustomerByIdUseCase findCustomerByIdUseCase;
    private final UpdateCustomerUseCase updateCustomerUseCase;
    private final DeleteCustomerByIdUseCase deleteCustomerByIdUseCase;

    public CustomerController(
            InsertCustomerUseCase insertCustomerUseCase,
            CustomerMapper customerMapper,
            FindCustomerByIdUseCase findCustomerByIdUseCase,
            UpdateCustomerUseCase updateCustomerUseCase,
            DeleteCustomerByIdUseCase deleteCustomerByIdUseCase
    ) {
        this.insertCustomerUseCase = insertCustomerUseCase;
        this.customerMapper = customerMapper;
        this.findCustomerByIdUseCase = findCustomerByIdUseCase;
        this.updateCustomerUseCase = updateCustomerUseCase;
        this.deleteCustomerByIdUseCase = deleteCustomerByIdUseCase;
    }

    @PostMapping
    public ResponseEntity<Void> insert(
            @RequestBody @Valid CustomerRequest customerRequest
    ) {
        Customer customer = customerMapper.toCustomer(customerRequest);
        insertCustomerUseCase.insert(customer, customerRequest.getZipcode());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable String id) {
        Customer customer = findCustomerByIdUseCase.find(id);
        CustomerResponse customerResponse = customerMapper.toCustomerResponse(customer);

        return ResponseEntity
                .ok(customerResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(
            @PathVariable String id,
            @RequestBody @Valid CustomerRequest customerRequest
    ) {
        Customer customer = customerMapper.toCustomer(customerRequest);
        customer.setId(id);

        updateCustomerUseCase.update(customer, customerRequest.getZipcode());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        deleteCustomerByIdUseCase.delete(id);
        return ResponseEntity.noContent().build();
    }
}
