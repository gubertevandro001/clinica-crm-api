package com.gpa.clinica.crm.api.controller.openapi;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

@Tag(name = "Pacientes e Conversas", description = "Gerencia as conversas dos pacientes")
public interface PacienteConversaControllerOpenAPI {

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Realiza o upload de uma conversa do paciente")
    @ApiResponse(responseCode = "204", description = "Conversa adicionada ao paciente!")
    @ApiResponse(responseCode = "400", description = "Erro de validação")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    public void adicionarConversa(@PathVariable String pacienteId, @RequestPart("file") MultipartFile file);
}
