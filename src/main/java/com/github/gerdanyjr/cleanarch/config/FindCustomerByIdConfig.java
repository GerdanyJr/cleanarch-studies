package com.github.gerdanyjr.cleanarch.config;

import com.github.gerdanyjr.cleanarch.core.usecase.impl.FindCustomerByIdUseCaseImpl;
import com.github.gerdanyjr.cleanarch.dataprovider.FindCustomerByIdImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindCustomerByIdConfig {

    @Bean
    public FindCustomerByIdUseCaseImpl findCustomerByIdUseCase(
            FindCustomerByIdImpl findCustomerByIdImpl
    ) {
        return new FindCustomerByIdUseCaseImpl(findCustomerByIdImpl);
    }
}
