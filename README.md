# Exercícios de Teste de Software - Mocks & Outros Test Doubles

Este repositório contém a resolução dos primeiros 4 exercícios práticos sobre **Test Doubles** (Dublês de Teste) solicitados para a atividade de Teste de Software. Todos os exercícios foram implementados em **Java 21** utilizando o framework **JUnit 5** e estruturados através do **Maven** como um projeto multi-módulos organizado e profissional.

---

## 📋 Mapeamento dos Exercícios

Conforme as definições dos tipos de Dublês de Teste, segue o mapeamento e a justificativa para cada um dos exercícios implementados:

| Exercício | Dublê de Teste | Justificativa |
| :--- | :--- | :--- |
| **Exercício 1** | **Dummy** | O objeto `DummyLogger` é fornecido ao construtor da `Calculadora` apenas para satisfazer a assinatura exigida na estrutura da aplicação. Ele não é de fato executado ou exercitado durante a lógica da soma. |
| **Exercício 2** | **Stub** | O `AlunoRepositoryStub` fornece respostas pré-programadas (*canned answers*) previamente controladas pelo teste (idades 17, 18 anos, etc.), simulando um banco de dados de maneira totalmente controlada. |
| **Exercício 3** | **Mock** | O `EmailServiceMock` é utilizado para verificar a interação entre objetos. Ele armazena o histórico e quantidade de chamadas para garantir que o envio do e-mail foi acionado corretamente e com os parâmetros corretos. |
| **Exercício 4** | **Fake** | O `FakeUsuarioRepository` é uma implementação simplificada, porém 100% funcional. Ele armazena de verdade os usuários cadastrados e impede duplicados utilizando um mapa em memória (`Map`), servindo para testes na ausência do banco de dados oficial. |

---

## 📁 Estrutura de Pastas

Conforme solicitado, cada exercício foi estruturado em sua respectiva pasta e pacotes de forma hierárquica:

```text
c:\Users\RD\Documents\Teste-software
├── pom.xml                   # Configuração Maven Pai
├── README.md                 # Este guia explicativo
├── ex01                      # Exercício 1 - Dummy
│   ├── pom.xml
│   └── src
│       ├── main/java/ex01    # Código Fonte (Calculadora e Logger)
│       └── test/java/ex01    # Código de Teste (DummyLogger e CalculadoraTest)
├── ex02                      # Exercício 2 - Stub
│   ├── pom.xml
│   └── src
│       ├── main/java/ex02    # Código Fonte (Aluno, AlunoRepository e Verificador)
│       └── test/java/ex02    # Código de Teste (AlunoRepositoryStub e VerificadorMaioridadeTest)
├── ex03                      # Exercício 3 - Mock
│   ├── pom.xml
│   └── src
│       ├── main/java/ex03    # Código Fonte (Cliente, EmailService e Cadastro)
│       └── test/java/ex03    # Código de Teste (EmailServiceMock e CadastroClienteServiceTest)
└── ex04                      # Exercício 4 - Fake
    ├── pom.xml
    └── src
        ├── main/java/ex04    # Código Fonte (Usuario, UsuarioRepository e Gerenciador)
        └── test/java/ex04    # Código de Teste (FakeUsuarioRepository e GerenciadorUsuarioTest)
```

---

## 🚀 Como Executar os Testes

Como o projeto está configurado via Maven, você pode compilar e executar os testes de todos os exercícios de uma única vez a partir do diretório raiz:

1. Abra um terminal no diretório do projeto (`c:\Users\RD\Documents\Teste-software`).
2. Execute o comando Maven:
   ```bash
   mvn test
   ```
3. O Maven executará de forma sequencial os testes de todas as pastas (`ex01`, `ex02`, `ex03` e `ex04`) e exibirá um relatório consolidado com 100% de sucesso.

---

*Observação: Conforme solicitado pelo professor, todos os arquivos de dublês de teste e classes de teste possuem um cabeçalho identificando explicitamente o tipo de teste utilizado.*
