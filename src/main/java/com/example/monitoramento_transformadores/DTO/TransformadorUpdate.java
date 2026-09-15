package com.example.monitoramento_transformadores.DTO;

import java.math.BigDecimal;

/**
 * Objeto responsavel por transportar os dados de requisição de atualização
 * entre as camadas Controller e Service*/
public record TransformadorUpdate(
        Long id,

        /**
         * Atributo representando Limite de Temperatura de Oleo de Transformador*/
        BigDecimal limiteTempOleo,

        /**
         * Atributo representando Limite de Temperatura de Enrolamento de Transformador*/
        BigDecimal limiteTempEnrolamento) {
}