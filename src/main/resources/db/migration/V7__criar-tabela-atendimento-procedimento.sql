CREATE TABLE atendimento_procedimento
(
    id              VARCHAR(32)    NOT NULL,
    procedimento_id VARCHAR(32)    NOT NULL,
    atendimento_id  VARCHAR(32)    NOT NULL,
    valor           DECIMAL(15, 2) NOT NULL,

    CONSTRAINT PK_atendimento_procedimento PRIMARY KEY (id),

    CONSTRAINT FK_at_proc_procedimento FOREIGN KEY (procedimento_id) REFERENCES procedimento (id),
    CONSTRAINT FK_at_proc_atendimento FOREIGN KEY (atendimento_id) REFERENCES atendimento (id)
);