package br.com.ronna.ms.visita.dtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


@Data
public class VisitaDto {

    @NotBlank
    private String visitaTexto;
    @NotNull
    private LocalDateTime visitaInicio;
    @NotNull
    private LocalDateTime visitaFim;
    @NotNull
    private Double visitaProdutoValue;
    @NotNull
    private String visitaFuncionarioId;
    @NotNull
    private Long visitaClienteId;
    @NotNull
    private Double visitaDesconto;

    private LocalDateTime visitaCreated;
    private LocalDateTime visitaUpdated;
}
