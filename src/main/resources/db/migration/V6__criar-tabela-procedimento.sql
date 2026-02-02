CREATE TABLE procedimento
(
    id        VARCHAR(32) NOT NULL,
    nome      VARCHAR(150) NOT NULL,
    descricao VARCHAR(300) NOT NULL,
    tipo      VARCHAR(150) NOT NULL,
    valor     DECIMAL(15, 2) NOT NULL,

    CONSTRAINT PK_procedimento PRIMARY KEY (id)
);