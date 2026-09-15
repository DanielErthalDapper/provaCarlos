package com.example.monitoramento_transformadores.DTO;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Objeto responsavel por transportar os dados de requisição
 * entre as camadas Controller e Service*/
public record TransformadorRequest(
        /**
         * Atributo representando Número de Série de Transformador*/
        String numeroSerie,

        /**
         * Atributo representando Modelo de Transformador*/
        String modelo,

        /**
         * Atributo representando Subestação de Transformador*/
        String subestacao,

        /**
         * Atributo representando Potência KVA de Transformador*/
        BigDecimal potenciaKva,

        /**
         * Atributo representando Limite de Temperatura de Oleo de Transformador*/
        BigDecimal limiteTempOleo,

        /**
         * Atributo representando Limite de Temperatura de Enrolamento de Transformador*/
        BigDecimal limiteTempEnrolamento) {
}
