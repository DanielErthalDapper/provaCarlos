package com.example.monitoramento_transformadores.DTO;

import com.example.monitoramento_transformadores.Entity.AlertaTermico;
import com.example.monitoramento_transformadores.Entity.LeituraTermica;
import com.example.monitoramento_transformadores.Entity.Tecnico;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;


/**
 * Objeto responsavel por transportar os dados de Resposta
 * entre as camadas Service e Controller*/
public record TransformadorResponse(
        Long id,
        String numeroSerie,
        String modelo,
        String subestacao,
        BigDecimal potenciaKva,
        BigDecimal limiteTempOleo,
        BigDecimal limiteTempEnrolamento,
        Set<Tecnico> tecnicos,
        Set<LeituraTermica> leituras,
        List<AlertaTermico> alertas) {
}
