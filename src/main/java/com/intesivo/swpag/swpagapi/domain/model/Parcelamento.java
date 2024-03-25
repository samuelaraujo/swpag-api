package com.intesivo.swpag.swpagapi.domain.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import jakarta.validation.groups.ConvertGroup;
import jakarta.validation.groups.Default;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Parcelamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Valid
    @NotNull
    @ManyToOne
    private Cliente cliente;

    @Column
    private String descricao;

    @Column(name = "quantidade_parcelas")
    @EqualsAndHashCode.Include
    private int quantidadeParcelas;

    @Column(name = "data_descricao")
    @EqualsAndHashCode.Include
    private LocalDate dataDescricao;

    @Column(name = "pago")
    @EqualsAndHashCode.Include
    private Boolean pago = false ;

    @Column(name = "valor_parcelamento")
    @EqualsAndHashCode.Include
    private BigDecimal valorParcelamento;

}