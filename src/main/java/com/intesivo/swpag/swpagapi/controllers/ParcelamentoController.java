package com.intesivo.swpag.swpagapi.controllers;

import com.intesivo.swpag.swpagapi.domain.exception.NegocioException;
import com.intesivo.swpag.swpagapi.domain.model.Cliente;
import com.intesivo.swpag.swpagapi.domain.model.Parcelamento;
import com.intesivo.swpag.swpagapi.domain.repositoy.ClienteRepository;
import com.intesivo.swpag.swpagapi.domain.repositoy.ParcelamentoRepository;
import com.intesivo.swpag.swpagapi.domain.service.CadastroClienteService;
import com.intesivo.swpag.swpagapi.domain.service.CadastroParcelamentoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/parcelamentos")
@RestController
@AllArgsConstructor
public class ParcelamentoController {

    private final CadastroParcelamentoService cadastroParcelamentoService;
    private final ParcelamentoRepository parcelamentoRepository;
    private final ClienteRepository clienteRepository;



    @GetMapping
    public List<Parcelamento> getParcelamento() {
        // Carregar os parcelamentos de todos os clientes

        return parcelamentoRepository.findAllParcelamentos();
    }
    // Endpoint para retornar a lista de parcelamento
   /* @GetMapping
    public List<Parcelamento> getParcelamento() { return parcelamentoRepository.findAll(); }*/

       // Endpoint para retornar parcelamento por id
    @GetMapping("/{parcelamentoId}")
    public ResponseEntity<Parcelamento> buscaCliente(@PathVariable Long parcelamentoId) {
        var  parcelamento = parcelamentoRepository.findById(parcelamentoId);
        if (parcelamento.isPresent()){return ResponseEntity.ok(parcelamento.get());}
        return  ResponseEntity.notFound().build() ;
    }

    // Endpoint para adicinar parcelamento, retorno parcelamento
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Parcelamento adicionar(@Valid @RequestBody Parcelamento parcelamento ){
      return cadastroParcelamentoService.salvar(parcelamento);
    }

    // Endpoint para atualizar um parcelamento
    @PutMapping("/{parcelamntoId}")
    public ResponseEntity<Parcelamento> atualizar(@PathVariable Long parcelamntoId,
                                             @Valid @RequestBody Parcelamento parcelamento){
        if (!parcelamentoRepository.existsById(parcelamntoId)) {
            return ResponseEntity.notFound().build();
        }
        parcelamento.setId(parcelamntoId);
        return ResponseEntity.ok(cadastroParcelamentoService.salvar(parcelamento));
    }

    // Endpoint para retornar adicinar cliente
    @DeleteMapping("/{parcelamentoId}")
    public ResponseEntity<Void> excluir(@PathVariable Long parcelamentoId){
        if (!parcelamentoRepository.existsById(parcelamentoId)) {
            return ResponseEntity.notFound().build();
        }
        cadastroParcelamentoService.excluir(parcelamentoId);
        return ResponseEntity.noContent().build();
    }
    @ExceptionHandler(NegocioException.class)
    public ResponseEntity<String> capturar(NegocioException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}