package com.intesivo.swpag.swpagapi.domain.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.mapping.ToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private String rua;
    private String numero;
    private String cidade;
    private String cep;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente cliente;


    @Override
    public String toString() {
        return "Endereco{" +
                "id=" + id +
                ", rua='" + rua + '\'' +
                ", numero='" + numero + '\'' +
                ", cidade='" + cidade + '\'' +
                ", cep='" + cep + '\'' +
                '}';
    }
}
