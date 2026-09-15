package com.example.monitoramento_transformadores.Entity;

import com.example.monitoramento_transformadores.ENUM.TipoAlertaTermico;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "alerta_termico")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
/**
 * Entidade Alerta Térmico
 * <p>Registro automático de anomalias operacionais<p/>*/
public class AlertaTermico
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_alerta", nullable = false)
    private LocalDateTime dataAlerta;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo")
    private TipoAlertaTermico tipo;

    @Column(name = "descricao")
    private String descricao;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "transformador_id", nullable = false)
    private Transformador transformador;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "leitura_id", nullable = false)
    private LeituraTermica leitura;
}
