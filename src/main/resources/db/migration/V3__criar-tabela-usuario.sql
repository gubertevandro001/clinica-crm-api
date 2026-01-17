CREATE TABLE usuario
(
    id       VARCHAR(36)  NOT NULL,
    nome     VARCHAR(150) NOT NULL,
    cpf      VARCHAR(14)  NOT NULL,
    email    VARCHAR(150) NOT NULL,
    login    VARCHAR(100) NOT NULL,
    password VARCHAR(255) NOT NULL,
    role     VARCHAR(50)  NOT NULL,
    ativo    BIT          NOT NULL,

    CONSTRAINT PK_usuario PRIMARY KEY (id),
    CONSTRAINT UK_usuario_email UNIQUE (email),
    CONSTRAINT UK_usuario_login UNIQUE (login),
    CONSTRAINT UK_usuario_cpf UNIQUE (cpf)
);