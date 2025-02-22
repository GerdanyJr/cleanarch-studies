package com.github.gerdanyjr.cleanarch.config;

import com.github.gerdanyjr.cleanarch.core.dataprovider.FindAddressByZipCode;
import com.github.gerdanyjr.cleanarch.core.dataprovider.UpdateCustomer;
import com.github.gerdanyjr.cleanarch.core.usecase.impl.FindCustomerByIdUseCaseImpl;
import com.github.gerdanyjr.cleanarch.core.usecase.impl.UpdateCustomerUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {

    @Bean
    public UpdateCustomerUseCaseImpl updateCustomerUseCase(
            FindCustomerByIdUseCaseImpl findCustomerByIdUseCaseImpl,
            FindAddressByZipCode findAddressByZipCode,
            UpdateCustomer updateCustomer) {
        return new UpdateCustomerUseCaseImpl(
                findCustomerByIdUseCaseImpl,
                findAddressByZipCode,
                updateCustomer
        );
    }
}
