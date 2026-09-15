package com.example.monitoramento_transformadores.Repository;

import com.example.monitoramento_transformadores.Entity.LeituraTermica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface responsável entre os dados da
 * Entidade Leitura Térmica e a conexão com o Banco de dados*/
@Repository
public interface LeituraTermicaRepository extends JpaRepository<LeituraTermica, Long> {
}
