package br.com.ronna.ms.visita.vo;

import br.com.ronna.ms.visita.models.VisitaModel;
import lombok.Data;

import java.util.List;

@Data
public class ResponseTemplateVO {
    private VisitaModel visitaModel;
    private ClienteModel clienteModel;
    private List<FuncionarioModel> funcionarioModel;
}
