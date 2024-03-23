package com.intesivo.swpag.swpagapi.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.print.DocFlavor;
import java.util.Collection;

@Getter
@Setter
public class Cliente {

    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private Collection<Endereco> endereco;

    public Cliente() {
    }



    @Override
    public String toString() {
        return "Cliente{}";
    }


}
