package com.github.gerdanyjr.cleanarch.dataprovider;

import com.github.gerdanyjr.cleanarch.core.dataprovider.FindAddressByZipCode;
import com.github.gerdanyjr.cleanarch.core.domain.Address;
import com.github.gerdanyjr.cleanarch.dataprovider.client.FindAddressByZipCodeClient;
import com.github.gerdanyjr.cleanarch.dataprovider.client.mapper.AddressResponseMapper;
import com.github.gerdanyjr.cleanarch.dataprovider.client.response.AddressResponse;
import org.springframework.stereotype.Component;

@Component
public class FindAddressByZipCodeImpl implements FindAddressByZipCode {

    private final AddressResponseMapper addressResponseMapper;
    private final FindAddressByZipCodeClient findAddressByZipCodeClient;

    public FindAddressByZipCodeImpl(AddressResponseMapper addressResponseMapper, FindAddressByZipCodeClient findAddressByZipCodeClient) {
        this.addressResponseMapper = addressResponseMapper;
        this.findAddressByZipCodeClient = findAddressByZipCodeClient;
    }

    @Override
    public Address find(String zipcode) {
        AddressResponse addressResponse = findAddressByZipCodeClient.find(zipcode);
        return addressResponseMapper.toAddress(addressResponse);
    }

}
