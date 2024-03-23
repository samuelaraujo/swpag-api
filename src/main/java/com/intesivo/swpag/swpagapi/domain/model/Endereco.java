package com.intesivo.swpag.swpagapi.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
public class Endereco {

    private String rua;
    private String numero;
    private String cidade;
    private String cep;
}
