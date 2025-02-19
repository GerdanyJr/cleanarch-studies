package com.github.gerdanyjr.cleanarch.entrypoint.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponse {

    private String name;

    private String cpf;

    private Boolean isValidCpf;

    private AddressResponse address;
}
