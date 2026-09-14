package com.example.monitoramento_transformadores.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "leitura_termica")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class LeituraTermica
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "temp_oleo", nullable = false)
    private BigDecimal tempOleo;

    @Column(name = "temp_enrolamento", nullable = false)
    private BigDecimal tempEnrolamento;

    @Column(name = "data_hora_leitura", nullable = false)
    private LocalDateTime dataHora;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "transformador_id", nullable = false)
    private Transformador transformador;

    @OneToOne(mappedBy = "leitura", cascade = CascadeType.ALL)
    @JoinColumn(name = "leitura_id", nullable = false)
    private AlertaTermico alerta;
}
