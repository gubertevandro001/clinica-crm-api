package com.gpa.clinica.crm.api.model.request;

import com.gpa.clinica.crm.domain.valueobject.Contato;
import jakarta.validation.constraints.NotBlank;

public record ContatoRequest(

        String telefone,

        @NotBlank
        String celular,

        @NotBlank
        String email
) {

    public static ContatoRequest aPartirDe(Contato contato) {
        return new ContatoRequest(
                contato.getTelefone(),
                contato.getCelular(),
                contato.getEmail()
        );
    }
}
