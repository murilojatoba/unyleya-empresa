--liquibase formatted sql

--changeset murilojatoba:1.0.0_001_DDL_CREATE_SCHEMA_EMPRESA

CREATE SCHEMA empresa;

--rollback drop schema empresa;