package com.intesivo.swpag.swpagapi.domain.repositoy;

import com.intesivo.swpag.swpagapi.domain.model.Cliente;
import com.intesivo.swpag.swpagapi.domain.model.Parcelamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface ParcelamentoRepository extends JpaRepository<Parcelamento, Long> {

    Optional<Parcelamento> findByDataDescricao (LocalDate data);

    @Query("SELECT p FROM Parcelamento p")
    List<Parcelamento> findAllParcelamentos();

}
