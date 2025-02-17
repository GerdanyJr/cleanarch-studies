package com.github.gerdanyjr.cleanarch.dataprovider.client;

import com.github.gerdanyjr.cleanarch.dataprovider.client.response.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "FindAddressByZipCodeClient",
        url = "${gerdany.client.address.url}"
)
public interface FindAddressByZipCodeClient {

    @GetMapping("/{zipcode}")
    AddressResponse find(@PathVariable("zipcode") String zipcode);
}
