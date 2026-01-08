package com.gpa.clinica.crm.api.model;

public record EnderecoModel(
        String cidade,
        String estado,
        String bairro,
        String cep,
        String logradouro,
        String numero,
        String complemento
) {}
