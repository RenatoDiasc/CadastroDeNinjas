-- Migrations para adicionar a coluna de telefone na tabela de cadastros

ALTER TABLE tb_cadastro
ADD COLUMN telefone VARCHAR (20);