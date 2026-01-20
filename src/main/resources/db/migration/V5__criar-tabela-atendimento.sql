CREATE TABLE atendimento
(
    id               VARCHAR(36)    NOT NULL,
    data_atendimento DATE           NOT NULL,
    valor            DECIMAL(15, 2) NOT NULL,
    paciente_id      VARCHAR(36)    NOT NULL,
    usuario_id       VARCHAR(36)    NOT NULL,

    CONSTRAINT PK_atendimento PRIMARY KEY (id),

    CONSTRAINT FK_atendimento_paciente FOREIGN KEY (paciente_id) REFERENCES paciente (id),
    CONSTRAINT FK_atendimento_usuario FOREIGN KEY (usuario_id) REFERENCES usuario (id)
);