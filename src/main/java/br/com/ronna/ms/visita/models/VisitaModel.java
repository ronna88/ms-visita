package br.com.ronna.ms.visita.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "TB_VISITA")
public class VisitaModel implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long visitaId;
    @Column(columnDefinition = "TEXT")
    private String visitaTexto;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm")
    private LocalDateTime visitaInicio;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm")
    private LocalDateTime visitaFim;
    private Double visitaProdutoValue;
    private String visitaFuncionarioId;
    private Long visitaClienteId;
    private Double visitaDesconto;
    private LocalDateTime visitaCreated;
    private LocalDateTime visitaUpdated;
}
