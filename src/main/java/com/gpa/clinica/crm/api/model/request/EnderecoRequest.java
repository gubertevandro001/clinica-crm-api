package com.gpa.clinica.crm.api.model.request;

import com.gpa.clinica.crm.domain.valueobject.Endereco;
import jakarta.validation.constraints.NotBlank;

public record EnderecoRequest(

        @NotBlank
        String cidade,

        @NotBlank
        String estado,

        @NotBlank
        String bairro,

        @NotBlank
        String cep,

        @NotBlank
        String logradouro,

        @NotBlank
        String numero,

        String complemento
) {

    public static EnderecoRequest aPartirDe(Endereco endereco) {
        return new EnderecoRequest(
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
