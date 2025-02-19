# Desafio: Consulta de Vendas - DevSuperior

Este repositório contém a implementação do desafio de consulta de vendas, parte do módulo **Back-end** do curso **Formação Desenvolvedor Moderno** da [DevSuperior](https://devsuperior.com.br).

## Objetivo
Trata-se de um sistema de vendas (Sale) e vendedores (Seller). Cada venda está associada a um vendedor, e um vendedor pode ter várias vendas. O desafio consiste na implementação de duas consultas essenciais:

1. **Relatório de Vendas**
2. **Sumário de Vendas por Vendedor**

## Requisitos do Desafio

### 1. Relatório de Vendas

- **Entrada:** O usuário informa, opcionalmente:
  - Data inicial
  - Data final
  - Trecho do nome do vendedor
- **Saída:** O sistema retorna uma listagem paginada contendo:
  - ID da venda
  - Data da venda
  - Quantia vendida
  - Nome do vendedor

#### Regras de Implementação

- Se a **data final** não for informada, considerar a data atual do sistema:
  ```java
  LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
  ```
- Se a **data inicial** não for informada, considerar a data de 1 ano antes da data final:
  ```java
  LocalDate result = minhaData.minusYears(1L);
  ```
- Se o **nome do vendedor** não for informado, considerar um texto vazio.
- Receber todos os dados como **String** no controller e converter para os tipos corretos no service.

### 2. Sumário de Vendas por Vendedor

- **Entrada:** O usuário informa, opcionalmente:
  - Data inicial
  - Data final
- **Saída:** O sistema retorna uma listagem contendo:
  - Nome do vendedor
  - Soma das vendas desse vendedor no período informado

#### Regras de Implementação

- As mesmas do **Relatório de Vendas**.

## Como o Trabalho Será Corrigido

### 1) Importação do Projeto

O professor deve ser capaz de clonar o repositório do GitHub, importar e executar o projeto na IDE sem necessidade de qualquer configuração adicional.

### 2) Testes Manuais no Postman

O professor testará a aplicação com as seguintes requisições (coleção Postman: [link](https://www.getpostman.com/collections/dea7904f994cb87c3d12)):

#### **Sumário de Vendas por Vendedor**

- **Teste 1**:
  ```http
  GET /sales/summary?minDate=2022-01-01&maxDate=2022-06-30
  ```
  **Resposta esperada:**
  ```json
  [
    { "sellerName": "Anakin", "total": 110571.0 },
    { "sellerName": "Logan", "total": 83587.0 },
    { "sellerName": "Loki Odinson", "total": 150597.0 },
    { "sellerName": "Padme", "total": 135902.0 },
    { "sellerName": "Thor Odinson", "total": 144896.0 }
  ]
  ```

- **Teste 2**:
  ```http
  GET /sales/summary
  ```
  **Retorna o sumário de vendas dos últimos 12 meses.**

#### **Relatório de Vendas**

- **Teste 1**:
  ```http
  GET /sales/report
  ```
  **Retorna o relatório de vendas dos últimos 12 meses.**

- **Teste 2**:
  ```http
  GET /sales/report?minDate=2022-05-01&maxDate=2022-05-31&name=odinson
  ```
  **Resposta esperada:**
  ```json
  {
    "content": [
      { "id": 9, "date": "2022-05-22", "amount": 19476.0, "sellerName": "Loki Odinson" },
      { "id": 10, "date": "2022-05-18", "amount": 20530.0, "sellerName": "Thor Odinson" },
      { "id": 12, "date": "2022-05-06", "amount": 21753.0, "sellerName": "Loki Odinson" }
    ]
  }
  ```

## Como Rodar o Projeto

1. **Fork o repositório original**: [https://github.com/JaymeFortes/Desafio4-DevSuperior-ConsultaVendas-JPQL-SpringBoot.git)
2. **Clone o repositório para sua máquina**:
   ```sh
   git clone https://github.com/seu-usuario/desafio-consulta-vendas.git
   ```
3. **Importe o projeto na IDE** (IntelliJ, Eclipse, VS Code, etc.).
4. **Execute o projeto**.
5. **Realize as requisições no Postman** utilizando os endpoints descritos acima.

## Entrega

1. **Fork o repositório** para o seu GitHub.
2. **Implemente as consultas** conforme as especificações.
3. **Suba o código** para o seu repositório.
4. **Envie o link do repositório** (não é necessário enviar um pull request).






