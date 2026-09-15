package com.example.monitoramento_transformadores.Controller;

import com.example.monitoramento_transformadores.DTO.TransformadorRequest;
import com.example.monitoramento_transformadores.DTO.TransformadorResponse;
import com.example.monitoramento_transformadores.DTO.TransformadorUpdate;
import com.example.monitoramento_transformadores.Service.TransformadorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "Transformador Controller",
        description = "Camada responsável por receber requisições e encaminhar as respostas ao usuário"
)

/**
 * Camada responsável por receber requisições e encaminhar as respostas ao usuário*/
@RestController
@RequestMapping("/api/v1/transformadores")
public class TransformadorController
{
    private final TransformadorService transformadorService;

    public TransformadorController(TransformadorService service)
    {
        this.transformadorService = service;
    }

    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Criação bem-sucedida"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad Request - Requisição malformada"
            )
    })
    @Operation(
            description = "Cadastra Novos Transformadores"
    )
    @PostMapping()
    public TransformadorResponse postTransformador(@RequestBody TransformadorRequest request)
    {
        return transformadorService.createTransformador(request);
    }

    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Retorno de Consultas Bem Sucedidas"
            )
    })
    @Operation(
            description = "Busca Todos Transformadores Cadastrados"
    )
    @GetMapping
    public List<TransformadorResponse> listAll()
    {
        return transformadorService.listAll();
    }


    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Retorno de Consultas Bem Sucedidas"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Bad Request - Retorno de Consulta malformada"
            )
    })
    @Operation(
            description = "Busca Transformadores Filtrando Pelo Número de Série"
    )
    @GetMapping("/{numeroSerie}")
    public TransformadorResponse listByNumeroSerie(@PathVariable String numeroSerie)
    {
        return transformadorService.listarPorNumeroSerie(numeroSerie);
    }


    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Retorno de Consultas Bem Sucedidas"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Bad Request - Retorno de Consulta malformada"
            )
    })
    @Operation(
            description = "Atualiza Limites de Temperatura dos Transformadores - Filtrando por Número de Série"
    )
    @PutMapping("/{numeroSerie}")
    public TransformadorResponse updateTransformadores(@RequestBody TransformadorUpdate update)
    {
        return transformadorService.updateTransformador(update);
    }


    @ApiResponses({
            @ApiResponse(
                    responseCode = "204",
                    description = "Remoção bem-sucedida de um Transformador"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Bad Request - Retorno de Consulta malformada"
            )
    })
    @Operation(
            description = "Apaga o Transformador do Banco Filtrando por Número de Série"
    )
    @DeleteMapping("/{numeroSerie}")
    public void deleteByNumeroSerie(@PathVariable String numeroSerie)
    {
        transformadorService.deleteTransformador(numeroSerie);
    }

}
