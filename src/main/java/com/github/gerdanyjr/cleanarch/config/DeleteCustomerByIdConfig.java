package com.github.gerdanyjr.cleanarch.config;

import com.github.gerdanyjr.cleanarch.core.dataprovider.DeleteCustomerById;
import com.github.gerdanyjr.cleanarch.core.usecase.impl.DeleteCustomerByIdUseCaseimpl;
import com.github.gerdanyjr.cleanarch.core.usecase.impl.FindCustomerByIdUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerByIdConfig {

    @Bean
    public DeleteCustomerByIdUseCaseimpl deleteCustomerByIdUseCase(
            FindCustomerByIdUseCaseImpl findCustomerByIdUseCaseImpl,
            DeleteCustomerById deleteCustomerById
    ) {
        return new DeleteCustomerByIdUseCaseimpl(
                findCustomerByIdUseCaseImpl,
                deleteCustomerById
        );
    }
}
