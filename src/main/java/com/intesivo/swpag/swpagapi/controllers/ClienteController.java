package com.intesivo.swpag.swpagapi.controllers;

import com.intesivo.swpag.swpagapi.domain.model.Cliente;
import com.intesivo.swpag.swpagapi.domain.repositoy.ClienteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RequestMapping("/clientes")
@RestController
public class ClienteController {


    private final ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepositoy) {
        this.clienteRepository = clienteRepositoy;
    }

    // Endpoint para retornar a lista de clientes
    @GetMapping
    public List<Cliente> getClientes() {
        return clienteRepository.findAll();
    }

    @GetMapping("/buscapartenome/{parteNome}")
    public ResponseEntity<Collection<Cliente>> buscar(@PathVariable String parteNome) {
        Collection listaNomes = clienteRepository.findByNomeContainingIgnoreCaseOrderByNomeAsc(parteNome);
        if (listaNomes.isEmpty()) {
           return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(listaNomes);
    }

    // Endpoint para retornar cliente por id
    @GetMapping("/{clienteId}")
    public ResponseEntity<Cliente> buscaCliente(@PathVariable Long clienteId) {
        var  cliente = clienteRepository.findById(clienteId);
        if (cliente.isPresent()){return ResponseEntity.ok(cliente.get());}
        return  ResponseEntity.notFound().build() ;
    }

    // Endpoint para retornar adicinar cliente
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Cliente adicionar(@RequestBody Cliente cliente){
      return clienteRepository.save(cliente);
    }

    // Endpoint para retornar adicinar cliente
    @PutMapping("/{clienteId}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long clienteId, @RequestBody Cliente cliente){
        if (!clienteRepository.existsById(clienteId)) {
            return ResponseEntity.notFound().build();
        }
        cliente.setId(clienteId);
        return ResponseEntity.ok(clienteRepository.save(cliente));
    }

    // Endpoint para retornar adicinar cliente
    @DeleteMapping("/{clienteId}")
    public ResponseEntity<Void> excluir(@PathVariable Long clienteId){
        if (!clienteRepository.existsById(clienteId)) {
            return ResponseEntity.notFound().build();
        }
        clienteRepository.deleteById(clienteId);
        return ResponseEntity.noContent().build();
    }



    /* Endpoint para retornar a lista de clientes inicial
    @GetMapping("/clientes1")
    public String getClientes1() {
        return "clientes1";

    } *
     */
}