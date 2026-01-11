package com.gpa.clinica.crm.domain.mapper;

import com.gpa.clinica.crm.api.model.EnderecoModel;
import com.gpa.clinica.crm.domain.model.Endereco;

public class EnderecoMapper {

    public static Endereco criarEndereco(EnderecoModel enderecoModel) {
        return new Endereco(
                enderecoModel.cidade(),
                enderecoModel.estado(),
                enderecoModel.bairro(),
                enderecoModel.cep(),
                enderecoModel.logradouro(),
                enderecoModel.numero(),
                enderecoModel.complemento()
        );
    }
}
