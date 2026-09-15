package com.example.monitoramento_transformadores.Exception;

/**
 * Classe responsável por gerar Excesões Personalizadas - utilizadas ao longo de todo o sistema*/
public class TransformadorNaoEncontrado extends RuntimeException {
    public TransformadorNaoEncontrado(String message) {
        super(message);
    }
}
