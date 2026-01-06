CREATE TABLE usuario_paciente
(
    usuario_id  VARCHAR(36) NOT NULL,
    paciente_id VARCHAR(36) NOT NULL,

    CONSTRAINT PK_usuario_paciente PRIMARY KEY (usuario_id, paciente_id),

    CONSTRAINT FK_usuario_paciente_usuario FOREIGN KEY (usuario_id) REFERENCES usuario (id) ON DELETE CASCADE,

    CONSTRAINT FK_usuario_paciente_paciente FOREIGN KEY (paciente_id) REFERENCES paciente (id) ON DELETE CASCADE
);
