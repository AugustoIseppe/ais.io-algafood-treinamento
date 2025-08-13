# 🍔 AIS.io Algafood API

![Java](https://img.shields.io/badge/Java-21-red?logo=java&logoColor=white)
![Spring
Boot](https://img.shields.io/badge/Spring%20Boot-3.5-green?logo=springboot&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue?logo=mysql&logoColor=white)
![License](https://img.shields.io/badge/license-MIT-lightgrey)
![Build](https://img.shields.io/badge/build-Maven-orange?logo=apachemaven)

> **Sistema de Delivery** desenvolvido com **Spring Boot 3.5**, **Java
> 21** e banco de dados **MySQL**, com suporte a migrações de banco,
> autenticação JWT, envio de e-mails e integração com AWS S3.

------------------------------------------------------------------------

## 📋 Índice

-   [Sobre o Projeto](#-sobre-o-projeto)
-   [Tecnologias Utilizadas](#-tecnologias-utilizadas)
-   [Arquitetura](#-arquitetura)
-   [Pré-requisitos](#-pré-requisitos)
-   [Instalação e Execução](#-instalação-e-execução)
-   [Migrations com Flyway](#-migrations-com-flyway)
-   [Documentação da API](#-documentação-da-api)
-   [Autenticação e Segurança](#-autenticação-e-segurança)
-   [Testes](#-testes)
-   [Licença](#-licença)

------------------------------------------------------------------------

## 📖 Sobre o Projeto

O **AIS.io Algafood API** é um sistema backend para gerenciar pedidos,
restaurantes, cardápios e entregas, ideal para plataformas de delivery.\
Ele implementa **boas práticas** como: - **API RESTful** com HATEOAS -
**Migração de banco** com Flyway - **Autenticação e autorização JWT** -
**Upload de arquivos** para AWS S3 - **Envio de e-mails
transacionais** - **Documentação automática com OpenAPI (Swagger)**

------------------------------------------------------------------------

## 🚀 Tecnologias Utilizadas

-   **Java 21**
-   **Spring Boot 3.5**
    -   Spring Web
    -   Spring Data JPA
    -   Spring Validation
    -   Spring Security
    -   Spring Mail
    -   Spring HATEOAS
    -   Spring Boot DevTools
-   **MySQL** (Connector J)
-   **Flyway** (Migrações de banco)
-   **AWS S3** (Armazenamento de arquivos)
-   **Lombok** (Redução de boilerplate)
-   **ModelMapper** (Conversão de DTOs)
-   **Commons Lang 3**
-   **Freemarker** (Templates de e-mail)
-   **OpenAPI / Swagger** (springdoc)
-   **Java JWT (Auth0)** (Autenticação JWT)
-   **JUnit + Spring Security Test** (Testes automatizados)

------------------------------------------------------------------------

## 🏗 Arquitetura

O projeto segue **arquitetura em camadas**:

    src/
     ├── api/  
         └── assembler
         └── controller
         └── exceptionHandler
         └── helpers
         └── model
             └── dto 
     ├── core/ 
         └── config
         └── email
         └── jackson
         └── modelmapper
         └── security
         └── storage
         └── validation
         └── web
     ├── domain/  
         └── exceptions
         └── model
         └── repository
         └── service
     └── infrastructure/        
         └── repository
         └── service
         └── spec
         └── storage
------------------------------------------------------------------------

## 🛠 Pré-requisitos

Antes de rodar o projeto, você precisa ter instalado: - [Java
21+](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html) -
[Maven 3.9+](https://maven.apache.org/download.cgi) - [MySQL
8+](https://dev.mysql.com/downloads/installer/) - Conta e credenciais da
[AWS S3](https://aws.amazon.com/s3/) (para upload de arquivos)

------------------------------------------------------------------------

## ⚙ Instalação e Execução

``` bash
# Clonar o repositório
git clone https://github.com/seu-usuario/ais.io-algafood-api.git

# Entrar no diretório
cd ais.io-algafood-api

# Configurar o application.properties
vim src/main/resources/application.properties

# Rodar a aplicação
mvn spring-boot:run
```

Exemplo de configuração `application.properties`:

``` properties
spring.datasource.url=jdbc:mysql://localhost:3306/algafood?serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=senha

# Flyway
spring.flyway.enabled=true

# AWS S3
aws.accessKeyId=SUA_ACCESS_KEY
aws.secretKey=SUA_SECRET_KEY
aws.s3.bucketName=nome-do-bucket

# JWT
jwt.secret=chave-secreta
jwt.expiration=86400000

# E-mail
spring.mail.host=smtp.seuservidor.com
spring.mail.username=seuemail
spring.mail.password=suasenha
```

------------------------------------------------------------------------

## 🗄 Migrations com Flyway

Criar nova migration:

``` bash
mvn flyway:migrate
```

Arquivos ficam em:

    src/main/resources/db/migration

Exemplo: `V1__create_tables.sql`

------------------------------------------------------------------------

## 📄 Documentação da API

Acesse a documentação interativa (Swagger UI) após subir o projeto:

    http://localhost:8080/swagger-ui.html

------------------------------------------------------------------------

## 🔐 Autenticação e Segurança

A API utiliza **JWT** para autenticação.\
Fluxo básico: 1. Realizar login e receber token 2. Enviar token no
header `Authorization: Bearer {token}` 3. Acessar endpoints protegidos

------------------------------------------------------------------------

## 🧪 Testes

Rodar todos os testes:

``` bash
mvn test
```

------------------------------------------------------------------------

## 📜 Licença

Este projeto é distribuído sob a licença **MIT**. Consulte o arquivo
`LICENSE` para mais detalhes.
