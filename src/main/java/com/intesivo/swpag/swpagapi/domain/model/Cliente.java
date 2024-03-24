package com.intesivo.swpag.swpagapi.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "Cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @NotBlank
    @Size(max = 255)
    private String nome;
    private String cpf;
    @NotBlank
    @Size(max = 255)
    @Email
    private String email;
    @NotBlank
    private String telefone;
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Collection<Endereco> endereco;

    public Cliente() {
    }

    public Cliente(Long id, String nome, String cpf, String email, String telefone) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
    }

    public Cliente(Long id, String nome, String cpf, String email, String telefone, Collection<Endereco> endereco) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente cliente)) return false;
        return Objects.equals(getId(), cliente.getId()) && Objects.equals(getNome(), cliente.getNome()) && Objects.equals(getCpf(), cliente.getCpf()) && Objects.equals(getEmail(), cliente.getEmail()) && Objects.equals(getTelefone(), cliente.getTelefone()) && Objects.equals(getEndereco(), cliente.getEndereco());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getCpf(), getEmail(), getTelefone(), getEndereco());
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }

}
