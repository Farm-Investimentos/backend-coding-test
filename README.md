# Teste de Backend - FarmTech

Este repositório contém o desafio técnico de backend. O objetivo é propor um exercício compreensível de Java e Spring Boot.

## Objetivo
Criar um microserviço para cadastro, edição e listagem de produtos usando **Spring Boot** e banco de dados em memória **H2**. A documentação da API deve estar disponível via **Swagger/SpringDoc**.

## O que você precisa entregar
- Código-fonte versionado neste repositório (pode criar um fork ou abrir um novo repositório público).
- API com operações de **criar**, **editar** e **listar** produtos.
- Documentação acessível em `/swagger-ui.html` ou `/swagger-ui/index.html`.
- Instruções simples para executar o projeto localmente.

## Requisitos funcionais
Cada produto deve possuir:
- **Nome** (obrigatório, sem espaços em branco, mínimo 3 caracteres, não pode haver nomes repetidos).
- **Status** com os valores: `Active`, `Inactive`, `Discontinued`, `In Testing`.
- **Data de criação** e **data de atualização**.

### Exemplo de contratos de API (contexto: agricultura e produtores rurais)
Use esses exemplos como referência para modelar seus endpoints. As rotas e nomes podem variar, desde que respeitem as regras de negócio.

- **Create product**
  - `POST /products`
  - Request body:
    ```json
    {
      "name": "Premium corn seeds",
      "status": "Active",
      "farmer": {
        "document": "12345678900",
        "farmName": "Fazenda Santa Luzia",
        "state": "GO"
      }
    }
    ```
  - Response (201):
    ```json
    {
      "id": 1,
      "name": "Premium corn seeds",
      "status": "Active",
      "farmer": {
        "document": "12345678900",
        "farmName": "Fazenda Santa Luzia",
        "state": "GO"
      },
      "createdAt": "2024-05-10T12:00:00Z",
      "updatedAt": "2024-05-10T12:00:00Z"
    }
    ```

- **Update product**
  - `PUT /products/{id}`
  - Request body (example changing product name and status):
    ```json
    {
      "name": "Premium corn seeds harvest 24/25",
      "status": "In Testing",
      "farmer": {
        "document": "12345678900",
        "farmName": "Fazenda Santa Luzia",
        "state": "GO"
      }
    }
    ```

- **List products**
  - `GET /products`
  - Response (200):
    ```json
    [
      {
        "id": 1,
        "name": "Premium corn seeds harvest 24/25",
        "status": "In Testing",
        "farmer": {
          "document": "12345678900",
          "farmName": "Fazenda Santa Luzia",
          "state": "GO"
        },
        "createdAt": "2024-05-10T12:00:00Z",
        "updatedAt": "2024-05-12T09:30:00Z"
      }
    ]
    ```

- **Get product by ID**
  - `GET /products/{id}`
  - Response (200): same shape as the `POST` and `PUT` examples.

### Regras de negócio
- Não pode existir produto com o mesmo nome.
- Não pode existir produto com nome em branco ou com menos de 3 caracteres.
- Utilize os métodos REST correspondentes a cada ação:
  - `GET` para listar ou buscar.
  - `POST` para criar.
  - `PUT` para editar.

## Passo a passo sugerido
1. **Criar o projeto**: use Spring Initializr com as dependências Web, H2 Database e SpringDoc OpenAPI.
2. **Modelar a entidade** `Produto` com os campos indicados e validações simples.
3. **Criar o repositório** usando Spring Data JPA para salvar e buscar dados no H2.
4. **Implementar o controlador REST** com endpoints para criar, editar e listar produtos.
5. **Adicionar a documentação** com SpringDoc (OpenAPI) para expor a interface no Swagger UI.
6. **Testar localmente** chamando os endpoints (Postman, cURL ou Swagger UI).

## Como executar localmente
1. Certifique-se de ter **Java 17+** e **Maven** instalados.
2. Instale as dependências e execute a aplicação:
   ```bash
   mvn spring-boot:run
   ```
3. A aplicação deve subir em `http://localhost:8080`. A interface do Swagger costuma ficar em:
   - `http://localhost:8080/swagger-ui.html`, ou
   - `http://localhost:8080/swagger-ui/index.html`

## Critérios de avaliação
- Organização do código e clareza das camadas (controller, service, repository).
- Validações e mensagens de erro que façam sentido para quem está consumindo a API.
- Uso correto dos métodos HTTP e dos códigos de status de resposta.
- Qualidade da documentação da API (Swagger).
- Simplicidade e clareza das instruções de execução no README.

## Dicas finais
- Não é necessário implementar autenticação ou autorização.
- Mantenha o código e os nomes das classes/métodos autoexplicativos.
- Commits pequenos e frequentes ajudam a entender sua linha de raciocínio.
- Se tiver dúvidas, escreva comentários curtos no código ou documente no README.
