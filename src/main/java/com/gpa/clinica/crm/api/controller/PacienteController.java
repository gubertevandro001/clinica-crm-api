package com.gpa.clinica.crm.api.controller;

import com.gpa.clinica.crm.api.controller.openapi.PacienteControllerOpenAPI;
import com.gpa.clinica.crm.api.model.CadastrarPacienteRequest;
import com.gpa.clinica.crm.api.model.CadastrarPacienteResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pacientes")
@RequiredArgsConstructor
public class PacienteController implements PacienteControllerOpenAPI {


    @Override
    public CadastrarPacienteResponse cadastrarPaciente(CadastrarPacienteRequest cadastrarPacienteRequest) {
        return null;
    }
}
