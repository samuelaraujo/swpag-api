package com.intesivo.swpag.swpagapi.domain.service;


import com.intesivo.swpag.swpagapi.domain.exception.NegocioException;
import com.intesivo.swpag.swpagapi.domain.model.Cliente;
import com.intesivo.swpag.swpagapi.domain.repositoy.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class CadastroClienteService {

    private final ClienteRepository clienteRepository;

    public Cliente buscar(Long clienteId) {
        return clienteRepository.findById(clienteId)
                .orElseThrow(() -> new NegocioException("Cliente não encontrado"));
    }

    @Transactional
    public Cliente salvar(Cliente cliente) {
        boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail())
                .filter(c -> !c.getId().equals(cliente.getId()))
                .isPresent();

        if (emailEmUso) {
            throw new NegocioException("Já existe um cliente cadastrado com este e-mail");
        }
        return clienteRepository.save(cliente);
    }

    @Transactional
    public void excluir(Long clienteId) {
        clienteRepository.deleteById(clienteId);
    }

}
