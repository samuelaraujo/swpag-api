package com.intesivo.swpag.swpagapi.domain.service;


import com.intesivo.swpag.swpagapi.domain.exception.NegocioException;
import com.intesivo.swpag.swpagapi.domain.model.Parcelamento;
import com.intesivo.swpag.swpagapi.domain.model.Parcelamento;
import com.intesivo.swpag.swpagapi.domain.repositoy.ParcelamentoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class CadastroParcelamentoService {

    private final ParcelamentoRepository parcelamentoRepository;

    public Parcelamento buscar(Long parcelamentoId) {
        return parcelamentoRepository.findById(parcelamentoId)
                .orElseThrow(() -> new NegocioException("Parcelamento não encontrado"));
    }

    @Transactional
    public Parcelamento salvar(Parcelamento parcelamento) {
        return parcelamentoRepository.save(parcelamento);
    }

    @Transactional
    public void excluir(Long parcelamentoId) {
        parcelamentoRepository.deleteById(parcelamentoId);
    }

}
