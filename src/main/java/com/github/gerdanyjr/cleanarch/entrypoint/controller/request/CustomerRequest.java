package com.github.gerdanyjr.cleanarch.entrypoint.controller.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequest {
    @NotBlank
    private String name;

    @NotBlank
    private String cpf;

    @NotBlank
    private String zipcode;
}
