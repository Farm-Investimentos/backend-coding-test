# backend-coding-test
Instruções do teste para backend da FarmTech


## O que é esperado?
Um microserviço para cadastro, edição e listagem de produtos utilizando SpringBoot e banco de dados em memória H2.

## Requisitos

- Dados do produto:
  - Nome
  - Status
  - Data de Criação
  - Data de Atualização
- Não devem existir produtos com o mesmo nome nem com nome em branco;
- Não devem existir produtos com tamanho do nome inferior a 3 caracteres;
- Status possíveis:
  - Ativo
  - Inativo
  - Fora de Linha
  - Em Homologação
- A documentação do serviço e métodos devem estar disponíveis com Swagger/SpringDoc.
- O código fonte deverá ser versionado no GitHub para posterior consulta.

## Dicas:
- Utilizar os métodos REST correspondentes a ação:
  - GET 
  - POST
  - PUT
- Não é necessário aplicar qualquer tipo de segurança ou autenticação nas requisições.


