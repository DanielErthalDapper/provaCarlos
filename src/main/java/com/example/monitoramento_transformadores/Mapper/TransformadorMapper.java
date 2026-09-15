package com.example.monitoramento_transformadores.Mapper;

import com.example.monitoramento_transformadores.DTO.TransformadorRequest;
import com.example.monitoramento_transformadores.DTO.TransformadorResponse;
import com.example.monitoramento_transformadores.Entity.Transformador;
import org.springframework.stereotype.Component;


/**
 * Classe responsável por realizar as conversões de Requisição para Entidade e Entidade para Resposta*/
@Component
public class TransformadorMapper
{
    public Transformador toEntity(TransformadorRequest request)
    {
        return Transformador.builder()
                .numeroSerie(request.numeroSerie())
                .modelo(request.modelo())
                .subestacao(request.subestacao())
                .potenciaKva(request.potenciaKva())
                .limiteTempOleo(request.limiteTempOleo())
                .limiteTempEnrolamento(request.limiteTempEnrolamento()).build();

    }

    public TransformadorResponse toResponse(Transformador transformador)
    {
        return new TransformadorResponse(
                transformador.getId(),
                transformador.getNumeroSerie(),
                transformador.getModelo(),
                transformador.getSubestacao(),
                transformador.getPotenciaKva(),
                transformador.getLimiteTempOleo(),
                transformador.getLimiteTempEnrolamento(),
                transformador.getTecnicos(),
                transformador.getLeituras(),
                transformador.getAlertas()
        );
    }
}
