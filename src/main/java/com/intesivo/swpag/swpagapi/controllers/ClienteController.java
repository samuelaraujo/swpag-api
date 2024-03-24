package com.intesivo.swpag.swpagapi.controllers;

import com.intesivo.swpag.swpagapi.domain.model.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ClienteController {
    @PersistenceContext
    private EntityManager manager;


    // Endpoint para retornar a lista de clientes
    @GetMapping("/clientes")
    public List<Cliente> getClientes() {
       return manager.createQuery("from Cliente", Cliente.class)
               .getResultList();

    }
    // Endpoint para retornar a lista de clientes

    /*@GetMapping("/clientes")
    public List<Cliente> getClientes() {
        var cliente = new Cliente(1L,
                "samuel araujo",
                "66293820215",
                "samueolbraz@araujo",
                "6899954248");
        return Arrays.asList(cliente);

    }
*/
    /* Endpoint para retornar a lista de clientes
    @GetMapping("/clientes1")
    public String getClientes1() {
        return "clientes1";

    } *
     */
}