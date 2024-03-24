-- Table for Cliente entity
CREATE TABLE Cliente (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(14),
    email VARCHAR(255) NOT NULL,
    telefone VARCHAR(20)
);

-- Table for Endereco entity
CREATE TABLE Endereco (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    rua VARCHAR(255) NOT NULL,
    numero VARCHAR(10) NOT NULL,
    cidade VARCHAR(255) NOT NULL,
    cep VARCHAR(10) ,
    cliente_id BIGINT NOT NULL,
    FOREIGN KEY (cliente_id) REFERENCES Cliente(id)
);