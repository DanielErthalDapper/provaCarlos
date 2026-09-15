package com.example.monitoramento_transformadores.Repository;

import com.example.monitoramento_transformadores.Entity.AlertaTermico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface responsável entre os dados da
 * Entidade Alerta Térmico e a conexão com o Banco de dados*/
@Repository
public interface AlertaTermicoRepository extends JpaRepository<AlertaTermico, Long> {
}
