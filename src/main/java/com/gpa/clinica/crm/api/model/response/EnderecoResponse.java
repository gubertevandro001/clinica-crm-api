package com.gpa.clinica.crm.api.model.response;

import com.gpa.clinica.crm.domain.valueobject.Endereco;

public record EnderecoResponse(
        String cidade,
        String estado,
        String bairro,
        String cep,
        String logradouro,
        String numero,
        String complemento
) {

    public static EnderecoResponse aPartirDe(Endereco endereco) {
        return new EnderecoResponse(
                endereco.getCidade(),
                endereco.getEstado(),
                endereco.getBairro(),
                endereco.getCep(),
                endereco.getLogradouro(),
                endereco.getNumero(),
                endereco.getComplemento()
        );
    }
}
