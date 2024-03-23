package com.intesivo.swpag.swpagapi.controllers;

import com.intesivo.swpag.swpagapi.domain.model.Cliente;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClienteController {

    // Simulação de uma lista de clientes
    private List<Cliente> clientes;

    // Endpoint para retornar a lista de clientes
    @GetMapping("/clientes")
    public List<Cliente> getClientes() {
        return clientes;

    }

    /* Endpoint para retornar a lista de clientes
    @GetMapping("/clientes1")
    public String getClientes1() {
        return "clientes1";

    } *
     */
}