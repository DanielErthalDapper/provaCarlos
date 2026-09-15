package com.example.monitoramento_transformadores.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "transformador")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
/**
 * Entidade Transformador
 * <p>Ativo físico monitorado na rede elétrica<p/>*/
public class Transformador
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_serie", unique = true, nullable = false)
    private String numeroSerie;

    @Column(name = "modelo", length = 100, nullable = false)
    private String modelo;

    @Column(name = "subestacao", length = 100, nullable = false)
    private String subestacao;

    @Column(name = "potencia_kva", nullable = false)
    private BigDecimal potenciaKva;

    @Column(name = "limite_temp_oleo", nullable = false)
    private BigDecimal limiteTempOleo;

    @Column(name = "limite_temp_enrol", nullable = false)
    private BigDecimal limiteTempEnrolamento;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "transformador_tecnico",
            joinColumns = @JoinColumn(name = "transformador_id"),
            inverseJoinColumns = @JoinColumn(name = "tecnico_id"))
    private Set<Tecnico> tecnicos = new HashSet<>();

    @OneToMany(mappedBy = "transformador", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<LeituraTermica> leituras = new HashSet<>();

    @OneToMany(mappedBy = "transformador", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<AlertaTermico> alertas;
}
