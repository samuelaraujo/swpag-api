package com.intesivo.swpag.swpagapi.domain.repositoy;

import com.intesivo.swpag.swpagapi.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositoy extends JpaRepository<Cliente, Long> {

}
