package com.github.gerdanyjr.cleanarch.dataprovider.repository.mapper;

import com.github.gerdanyjr.cleanarch.core.domain.Customer;
import com.github.gerdanyjr.cleanarch.dataprovider.repository.entity.CustomerEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {

    CustomerEntity toEntity(Customer customer);

    Customer toCustomer(CustomerEntity customerEntity);
}
