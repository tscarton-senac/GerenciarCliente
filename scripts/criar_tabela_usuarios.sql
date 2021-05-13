CREATE TABLE usuario (
   id INT not null primary key
        GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),
   nome VARCHAR(255),
   login VARCHAR(255),
   senha VARCHAR(255),
   perfil VARCHAR(255),
    filial VARCHAR(255)
);

insert into usuario (nome, login, senha, perfil, filial) values  ('Administrator', 'admin', '$2a$12$5Uiekn3kh9DdEdVO.XyoRe6xM9dw/v6RHVtOsexJLn4xgHAIbdC1q', 'ADMIN', 'SP');
insert into usuario (nome, login, senha, perfil, filial) values  ('Mike Wilson', 'mike', '$2a$12$5Uiekn3kh9DdEdVO.XyoRe6xM9dw/v6RHVtOsexJLn4xgHAIbdC1q', 'GERENTE', 'SP');
insert into usuario (nome, login, senha, perfil, filial) values  ('John Peter', 'john', '$2a$12$5Uiekn3kh9DdEdVO.XyoRe6xM9dw/v6RHVtOsexJLn4xgHAIbdC1q', 'VENDEDOR', 'SP');