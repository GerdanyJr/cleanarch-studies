package com.github.gerdanyjr.cleanarch.config;

import com.github.gerdanyjr.cleanarch.core.dataprovider.FindAddressByZipCode;
import com.github.gerdanyjr.cleanarch.core.dataprovider.InsertCustomer;
import com.github.gerdanyjr.cleanarch.core.dataprovider.SendCpfForValidation;
import com.github.gerdanyjr.cleanarch.core.usecase.impl.InsertCustomerUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

    @Bean
    public InsertCustomerUseCaseImpl insertCustomerUseCase(
            FindAddressByZipCode findAddressByZipCode,
            InsertCustomer insertCustomer,
            SendCpfForValidation sendCpfForValidation
    ) {

        return new InsertCustomerUseCaseImpl(
                findAddressByZipCode,
                insertCustomer,
                sendCpfForValidation
        );
    }

}
