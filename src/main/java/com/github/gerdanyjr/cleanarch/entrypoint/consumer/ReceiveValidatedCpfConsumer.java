package com.github.gerdanyjr.cleanarch.entrypoint.consumer;

import com.github.gerdanyjr.cleanarch.core.domain.Customer;
import com.github.gerdanyjr.cleanarch.core.usecase.UpdateCustomerUseCase;
import com.github.gerdanyjr.cleanarch.entrypoint.consumer.mapper.CustomerMessageMapper;
import com.github.gerdanyjr.cleanarch.entrypoint.consumer.message.CustomerMessage;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveValidatedCpfConsumer {

    private final UpdateCustomerUseCase updateCustomerUseCase;
    private final CustomerMessageMapper customerMessageMapper;

    public ReceiveValidatedCpfConsumer(
            UpdateCustomerUseCase updateCustomerUseCase,
            CustomerMessageMapper customerMessageMapper
    ) {
        this.updateCustomerUseCase = updateCustomerUseCase;
        this.customerMessageMapper = customerMessageMapper;
    }

    @KafkaListener(topics = "tp-cpf-validated", groupId = "gerdany")
    public void receive(CustomerMessage message) {
        Customer customer = customerMessageMapper.toCustomer(message);
        updateCustomerUseCase.update(customer, message.getZipCode());
    }

}
