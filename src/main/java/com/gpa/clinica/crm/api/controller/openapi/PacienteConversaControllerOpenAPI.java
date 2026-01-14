package com.gpa.clinica.crm.api.controller.openapi;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

@Tag(name = "Paciente e Conversas", description = "Gerencia as conversas dos pacientes")
public interface PacienteConversaControllerOpenAPI {

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiResponse(responseCode = "204", description = "Conversa adicionada ao paciente!")
    @ApiResponse(responseCode = "400", description = "Erro de validação")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    public void adicionarConversa(@PathVariable String pacienteId, @RequestParam("file") MultipartFile file);
}
