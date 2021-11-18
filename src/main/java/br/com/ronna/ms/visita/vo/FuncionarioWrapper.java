package br.com.ronna.ms.visita.vo;

import java.util.List;

public class FuncionarioWrapper {

    private List<FuncionarioModel> funcionarios;

    public List<FuncionarioModel> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<FuncionarioModel> funcionarios) {
        this.funcionarios = funcionarios;
    }
}
