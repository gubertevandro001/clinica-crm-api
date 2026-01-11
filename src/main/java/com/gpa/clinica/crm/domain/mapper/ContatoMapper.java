package com.gpa.clinica.crm.domain.mapper;

import com.gpa.clinica.crm.api.model.ContatoModel;
import com.gpa.clinica.crm.domain.model.Contato;

public class ContatoMapper {

    public static Contato criarContato(ContatoModel contatoModel) {
        return new Contato(
                contatoModel.telefone(),
                contatoModel.celular(),
                contatoModel.email()
        );
    }
}
