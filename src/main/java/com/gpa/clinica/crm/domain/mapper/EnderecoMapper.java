package com.gpa.clinica.crm.domain.mapper;

import com.gpa.clinica.crm.api.model.request.EnderecoRequest;
import com.gpa.clinica.crm.domain.valueobject.Endereco;

public class EnderecoMapper {

    public static Endereco criarEndereco(EnderecoRequest enderecoRequest) {
        return new Endereco(
                enderecoRequest.cidade(),
                enderecoRequest.estado(),
                enderecoRequest.bairro(),
                enderecoRequest.cep(),
                enderecoRequest.logradouro(),
                enderecoRequest.numero(),
                enderecoRequest.complemento()
        );
    }
}
