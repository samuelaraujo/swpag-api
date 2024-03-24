package com.intesivo.swpag.swpagapi.controllers;

import com.intesivo.swpag.swpagapi.domain.model.Cliente;
import com.intesivo.swpag.swpagapi.domain.repositoy.ClienteRepositoy;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.apache.catalina.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClienteController {


    private ClienteRepositoy clienteRepositoy;

    public ClienteController(ClienteRepositoy clienteRepositoy) {
        this.clienteRepositoy = clienteRepositoy;
    }

    // Endpoint para retornar a lista de clientes
    @GetMapping("/clientes")
    public List<Cliente> getClientes() {
        return clienteRepositoy.findAll();
    }

    /* Endpoint para retornar a lista de clientes inicial
    @GetMapping("/clientes1")
    public String getClientes1() {
        return "clientes1";

    } *
     */
}