--liquibase formatted sql

--changeset murilojatoba:1.0.0_002_DDL_CREATE_TABLE_TB_EMPRESA

CREATE SEQUENCE IF NOT EXISTS empresa.tb_empresa_seq;
ALTER SEQUENCE empresa.tb_empresa_seq OWNER TO postgres;

CREATE TABLE empresa.tb_empresa (
	id int4 not null default nextval('empresa.tb_empresa_seq'),
	nome varchar(200) not null,
	endereco varchar(500) not null,
	constraint tb_empresa_pk primary key (id)
);

--rollback drop table empresa.tb_empresa;
--rollback drop sequence empresa.tb_empresa_seq;


--changeset murilojatoba:1.0.0_002_DDL_CREATE_TABLE_TB_EMPRESA_2

INSERT INTO empresa.tb_empresa (nome, endereco)
VALUES ('Unyleya - Salvador', 'Av Tancredo Neves, 1632, Salvador - BA, 41820-020');

--rollback delete from empresa.tb_empresa where nome = 'Unyleya - Salvador';