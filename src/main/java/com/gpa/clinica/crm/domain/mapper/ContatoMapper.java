package com.gpa.clinica.crm.domain.mapper;

import com.gpa.clinica.crm.api.model.request.ContatoRequest;
import com.gpa.clinica.crm.domain.valueobject.Contato;

public class ContatoMapper {

    public static Contato criarContato(ContatoRequest contatoRequest) {
        return new Contato(
                contatoRequest.telefone(),
                contatoRequest.celular(),
                contatoRequest.email()
        );
    }
}
