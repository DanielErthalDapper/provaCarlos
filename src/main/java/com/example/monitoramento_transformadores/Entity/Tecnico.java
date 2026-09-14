package com.example.monitoramento_transformadores.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tecnico")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Tecnico
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "cpf", unique = true, nullable = false)
    private String cpf;

    @Column(name = "especialidade")
    private String especialidade;

    @Column(name = "email")
    private String email;

    @ManyToMany(mappedBy = "tecnicos")
    private Set<Transformador> transformadores;
}
