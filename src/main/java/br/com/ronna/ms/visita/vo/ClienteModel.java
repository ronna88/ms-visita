package br.com.ronna.ms.visita.vo;

import lombok.Data;

@Data
public class ClienteModel{

        private String clienteNome;
        private String clienteRazaoSocial;
        private String clienteCpfCnpj;
        private String clienteEndereco;
        private String clienteCEP;
        private String clienteBairro;
        private String clienteTelefone;
        private Long clienteEmpresaId;
        private Long clienteContratoId;
}
