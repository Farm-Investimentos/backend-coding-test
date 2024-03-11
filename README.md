
# Backend Coding Test

Projeto de implementação de um microserviço para cadastro, edição e listagem de produtos
## Stack utilizada

**Back-end:** JDK 17, Spring Boot 3.2.3, Maven

## Funcionalidades

- Cadastro de Produtos
- Edição de Produtos
- Listagem de Produtos


## Instalação

Instale o projeto e suas dependencias utilizando o comando maven:

```bash
  $ mvn clean install
```

## Rodando aplicação localmente

* Clone o repositório
* Certifique-se de usar JDK 17

Existem várias maneiras de executar uma aplicação Spring Boot localmente. Uma maneira é executar o método `main` na classe `br.com.farmtech.codingtest.CodingTestApplication` do seu IDE.

Depois que a aplicação for executada com sucesso, você deverá ver algo como:

```
2024-03-11T11:11:42.158-03:00  INFO 15336 --- [  restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8080 (http) with context path ''
2024-03-11T11:11:42.171-03:00  INFO 15336 --- [  restartedMain] b.c.f.codingtest.CodingTestApplication   : Started CodingTestApplication in 6.947 seconds (process running for 8.131)
```

A aplicação ficará disponível via localhost:8080

## Documentação de API Swagger Docs
Toda documentação da API está disponível através do Swagger:
```
localhost:8080/swagger-ui/index.html#/
```