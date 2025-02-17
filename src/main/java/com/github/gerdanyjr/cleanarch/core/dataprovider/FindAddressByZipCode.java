package com.github.gerdanyjr.cleanarch.core.dataprovider;

import com.github.gerdanyjr.cleanarch.core.domain.Address;

public interface FindAddressByZipCode {

    Address find(String zipcode);
}
