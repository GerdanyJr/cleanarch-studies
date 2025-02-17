package com.github.gerdanyjr.cleanarch.dataprovider.client.mapper;

import com.github.gerdanyjr.cleanarch.core.domain.Address;
import com.github.gerdanyjr.cleanarch.dataprovider.client.response.AddressResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {

    Address toAddress(AddressResponse addressResponse);

}
