# Exercícios de Teste de Software - Mocks & Outros Test Doubles

Este repositório contém a resolução completa dos 8 exercícios práticos sobre **Test Doubles** (Dublês de Teste) e conceitos de testes unitários e de integração solicitados para a atividade de Teste de Software. Todos os exercícios foram implementados em **Java 21** utilizando o framework **JUnit 5** e estruturados através do **Maven** como projetos totalmente autônomos e integrados de forma profissional.

---

## Mapeamento dos Exercícios

Conforme as definições teóricas dos tipos de testes e Dublês de Teste, segue o mapeamento e a justificativa para os 8 exercícios implementados:

| Exercício | Tipo de Teste / Dublê | Justificativa do Cenário |
| :--- | :--- | :--- |
| **Exercício 1** | **Dummy** | O objeto `DummyLogger` é fornecido ao construtor da `Calculadora` apenas para satisfazer a assinatura exigida na estrutura da aplicação. Ele não é de fato executado ou consultado na lógica de soma. |
| **Exercício 2** | **Stub** | O `AlunoRepositoryStub` fornece respostas pré-programadas (*canned answers*) previamente controladas pelo teste (idades 17, 18 anos, etc.), simulando o componente de busca de forma estável. |
| **Exercício 3** | **Mock** | O `EmailServiceMock` é utilizado para verificar a interação entre objetos. Ele armazena o histórico e quantidade de chamadas para garantir que o envio de e-mail foi acionado com os parâmetros corretos ao cadastrar. |
| **Exercício 4** | **Fake** | O `FakeUsuarioRepository` é uma implementação simplificada, porém 100% funcional. Ele armazena de verdade os usuários cadastrados em memória (`Map`), simulando o banco de dados oficial ausente. |
| **Exercício 5** | **Teste Unitário** | Focado em testes unitários de estado (sem dependências/dublês). Valida o comportamento interno da lógica de desconto de compras premium com valores válidos, sem desconto e entradas inválidas. |
| **Exercício 6** | **Stub** | O `ServicoPagamentoStub` simula um gateway de pagamento externo retornando resultados estáticos de transações (aprovado ou recusado) pré-definidos pelo teste para isolar a regra do pedido. |
| **Exercício 7** | **Stub** | O `FuncionarioRepositoryStub` fornece funcionários específicos ou retorna nulo sob demanda para isolar o sistema de autenticação de infraestruturas reais e testar credenciais inválidas ou corretas. |
| **Exercício 8** | **Teste de Integração** | Foca no teste de múltiplos componentes reais trabalhando em conjunto (`GerenciadorProdutos`, `ProdutoRepository` real e `Produto`), sem usar dublês, para validar o fluxo ponta a ponta. |

---

## Estrutura de Pastas

Cada exercício está em uma pasta dedicada seguindo a estrutura autônoma e Maven:

```text
c:\Users\RD\Documents\Teste-software
├── pom.xml                   # Configuração Maven de Agregação
├── README.md                 # Este guia explicativo completo
├── ex01                      # Exercício 1 - Dummy (Calculadora e Logger)
├── ex02                      # Exercício 2 - Stub (Maioridade de Aluno)
├── ex03                      # Exercício 3 - Mock (Envio de e-mail após Cadastro)
├── ex04                      # Exercício 4 - Fake (Banco de dados de Usuários em Memória)
├── ex05                      # Exercício 5 - Teste Unitário (Cálculo de Desconto Premium)
├── ex06                      # Exercício 6 - Stub (Finalização de Pedidos com Pagamento Externo)
├── ex07                      # Exercício 7 - Stub (Autenticação de Funcionários)
└── ex08                      # Exercício 8 - Teste de Integração (Gerenciador de Produtos Real)
```

---

## Como Executar os Testes

Como o projeto está configurado via Maven de forma integrada e autônoma, você pode executar as seguintes operações:

### 1. Executar todos os exercícios juntos (a partir da raiz)
Abra um terminal no diretório do projeto (`c:\Users\RD\Documents\Teste-software`) e execute:
```bash
mvn test
```
O Maven compilará e rodará os testes de todos os 8 módulos em sequência, apresentando um relatório consolidado com 100% de sucesso.

### 2. Executar um exercício isolado
Por termos tornado todos os projetos **totalmente autônomos**, você pode abrir qualquer pasta de exercício (ex.: `ex05/`) no seu terminal ou IDE de preferência e rodar:
```bash
mvn test
```
Isso executará somente os testes daquele exercício de forma limpa e isolada, sem problemas de caminhos de projeto ou dependências externas!

---

*Observação: Todos os arquivos de código-fonte de teste e dublês possuem um cabeçalho identificando explicitamente o tipo de teste e dublê utilizado, conforme solicitado.*
