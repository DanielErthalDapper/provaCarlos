package com.example.monitoramento_transformadores.Repository;

import com.example.monitoramento_transformadores.Entity.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface responsável entre os dados da
 * Entidade Técnico e a conexão com o Banco de dados*/
@Repository
public interface TecnicoRepository extends JpaRepository<Tecnico, Long> {
}
