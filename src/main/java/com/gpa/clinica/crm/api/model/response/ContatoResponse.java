package com.gpa.clinica.crm.api.model.response;

import com.gpa.clinica.crm.domain.valueobject.Contato;

public record ContatoResponse(
        String telefone,
        String celular,
        String email
) {

    public static ContatoResponse aPartirDe(Contato contato) {
        return new ContatoResponse(
                contato.getTelefone(),
                contato.getCelular(),
                contato.getEmail()
        );
    }
}
