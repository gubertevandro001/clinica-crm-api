CREATE TABLE conversa
(
    id          VARCHAR(36) NOT NULL,
    conteudo    NVARCHAR(MAX) NOT NULL,
    paciente_id VARCHAR(36) NOT NULL,
    usuario_id  VARCHAR(36) NOT NULL

    CONSTRAINT PK_conversa PRIMARY KEY (id),

    CONSTRAINT  FK_conversa_paciente FOREIGN KEY (paciente_id) REFERENCES paciente(id),
    CONSTRAINT  FK_conversa_usuario FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);