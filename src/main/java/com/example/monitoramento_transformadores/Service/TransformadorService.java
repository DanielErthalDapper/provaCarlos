package com.example.monitoramento_transformadores.Service;

import com.example.monitoramento_transformadores.DTO.TransformadorRequest;
import com.example.monitoramento_transformadores.DTO.TransformadorResponse;
import com.example.monitoramento_transformadores.DTO.TransformadorUpdate;
import com.example.monitoramento_transformadores.Entity.Transformador;
import com.example.monitoramento_transformadores.Exception.TransformadorNaoEncontrado;
import com.example.monitoramento_transformadores.Mapper.TransformadorMapper;
import com.example.monitoramento_transformadores.Repository.TransformadorRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Classe responsável por controlar Regras de Negócio e
 * Lógica Bruta do Sistema*/
@Service
public class TransformadorService
{
    private final TransformadorRepository transformadorRepository;
    private final TransformadorMapper transformadorMapper;

    public TransformadorService(TransformadorRepository repository, TransformadorMapper mapper)
    {
        this.transformadorRepository = repository;
        this.transformadorMapper = mapper;
    }

    public List<TransformadorResponse> listAll()
    {
        return Collections.singletonList(transformadorMapper.toResponse((Transformador) transformadorRepository.findAll().stream().toList()));
    }

    public TransformadorResponse listarPorNumeroSerie(String numeroSerie)
    {
        return transformadorMapper.toResponse(transformadorRepository.findByNumeroSerie(numeroSerie));
    }

    public Optional<Transformador> listById(TransformadorUpdate update)
    {
        return transformadorRepository.findById(update.id());
    }

    public TransformadorResponse updateTransformador(TransformadorUpdate update)
    {
        Transformador transformador = listById(update).orElseThrow(() -> new TransformadorNaoEncontrado("não encontrado com o ID:" + update.id()));

        transformador.setLimiteTempEnrolamento(update.limiteTempEnrolamento());
        transformador.setLimiteTempOleo(update.limiteTempOleo());

        return transformadorMapper.toResponse(transformadorRepository.save(transformador));
    }

    public TransformadorResponse createTransformador(TransformadorRequest request)
    {
        Transformador transformador = transformadorMapper.toEntity(request);

        return transformadorMapper.toResponse(transformadorRepository.save(transformador));
    }

    public void deleteTransformador(String numeroSerie)
    {
        Transformador transformador = transformadorRepository.findByNumeroSerie(numeroSerie);

        transformadorRepository.delete(transformador);
    }
}
