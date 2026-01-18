package com.gpa.clinica.crm.api.controller;

import com.gpa.clinica.crm.api.controller.openapi.PacienteConversaControllerOpenAPI;
import com.gpa.clinica.crm.domain.service.PacienteService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/pacientes/{pacienteId}/conversas")
public class PacienteConversaController implements PacienteConversaControllerOpenAPI {

    private final PacienteService pacienteService;

    public PacienteConversaController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @Override
    public void adicionarConversa(String pacienteId, MultipartFile file) {
        pacienteService.adicionarConversa(pacienteId, file);
    }
}
