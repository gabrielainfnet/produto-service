CREATE TABLE PRODUTO
(
    id         BIGINT PRIMARY KEY,
    nome       VARCHAR(255),
    descricao  VARCHAR(255),
    preco      DECIMAL(10, 2),
    quantidade INT
);
