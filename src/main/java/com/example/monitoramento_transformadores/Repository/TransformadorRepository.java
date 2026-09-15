package com.example.monitoramento_transformadores.Repository;

import com.example.monitoramento_transformadores.DTO.TransformadorResponse;
import com.example.monitoramento_transformadores.Entity.Transformador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface responsável entre os dados da
 * Entidade Transformador e a conexão com o Banco de dados*/
@Repository
public interface TransformadorRepository extends JpaRepository<Transformador, Long>
{
    Transformador findByNumeroSerie(String numeroSerie);
}
