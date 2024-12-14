# Unyleya-Empresa
Pós-graduação em Desenvolvimento Fullstack - Unyleya

Projeto de entrega da unidade 3.

## Banco de Dados
O banco de dados utilizado foi o Postgres.
Os scripts estão em src/main/resources/migrations.

### Docker
Caso não possua um ambiente postgres instalado, mas conheça Docker e DockerCompose, os artefatos necessários para subir o banco de dados em docker estão na pasta devops/docker.
```
# executar o comando abaixo dentro da pasta devops/docker
docker-compose up -d
```

### Liquibase
Caso tenha o Liquibase instaldo, os scripts podem ser executados utilizando o comando abaixo:
```
# executar o comando na raiz do projeto
liquibase update
```