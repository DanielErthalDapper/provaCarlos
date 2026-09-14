package com.example.monitoramento_transformadores.Entity;

import com.example.monitoramento_transformadores.ENUM.TipoAlertaTermico;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "alerta_termico")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class AlertaTermico
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "data_alerta", nullable = false)
    private LocalDateTime dataAlerta;

    @Column(name = "tipo")
    private TipoAlertaTermico tipo;

    @Column(name = "descricao")
    private String descricao;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "transformador_id", nullable = false)
    private Transformador transformador;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    private LeituraTermica leitura;
}
