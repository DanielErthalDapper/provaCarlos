package com.example.monitoramento_transformadores.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "tecnico")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
/**
 * Entidade Técnico
 * <p>Profissional habilitado para manutenção<p/>*/
public class Tecnico
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "cpf", unique = true, nullable = false)
    private String cpf;

    @Column(name = "especialidade")
    private String especialidade;

    @Column(name = "email")
    private String email;

    @ManyToMany(mappedBy = "tecnicos", fetch = FetchType.LAZY)
    private Set<Transformador> transformadores = new HashSet<>();
}
