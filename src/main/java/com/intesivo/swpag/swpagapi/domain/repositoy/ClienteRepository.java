package com.intesivo.swpag.swpagapi.domain.repositoy;

import com.intesivo.swpag.swpagapi.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Collection<Cliente>  findByNomeContainingIgnoreCaseOrderByNomeAsc(String nome);
    Collection<Cliente> findByNomeContaining(String nome);
    Optional<Cliente> findByEmail (String email);

}
