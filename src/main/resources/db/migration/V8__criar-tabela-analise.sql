CREATE TABLE analise
(
    id              VARCHAR(32)  NOT NULL,
    paciente_id     VARCHAR(32)  NOT NULL,
    usuario_id      VARCHAR(32)  NOT NULL,
    conteudo        NVARCHAR(MAX) NOT NULL,
    data_analise    DATETIME      NOT NULL

    CONSTRAINT PK_analise PRIMARY KEY (id),
    CONSTRAINT FK_analise_paciente FOREIGN KEY (paciente_id) REFERENCES paciente(id),
    CONSTRAINT FK_analise_usuario FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);