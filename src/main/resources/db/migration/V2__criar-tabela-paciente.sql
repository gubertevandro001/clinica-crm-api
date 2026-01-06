CREATE TABLE paciente
(
    id                   VARCHAR(36) NOT NULL,
    nome                 VARCHAR(255),
    cpf                  VARCHAR(20),
    idade                INT,
    data_nascimento      DATE,
    profissao            VARCHAR(255),
    estado_civil         VARCHAR(100),
    endereco_cidade      VARCHAR(150),
    endereco_estado      VARCHAR(100),
    endereco_bairro      VARCHAR(150),
    endereco_cep         VARCHAR(20),
    endereco_logradouro  VARCHAR(255),
    endereco_numero      VARCHAR(20),
    endereco_complemento VARCHAR(255),
    telefone             VARCHAR(20),
    celular              VARCHAR(20),
    email                VARCHAR(255),
    anamnese_id          VARCHAR(36),

    CONSTRAINT PK_paciente PRIMARY KEY (id),

    CONSTRAINT FK_paciente_anamnese FOREIGN KEY (anamnese_id) REFERENCES anamnese (id)
);
