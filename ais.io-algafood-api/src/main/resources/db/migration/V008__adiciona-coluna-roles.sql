-- V008__adiciona-coluna-roles.sql
ALTER TABLE usuario ADD COLUMN roles VARCHAR(50) NOT NULL DEFAULT 'USER';
