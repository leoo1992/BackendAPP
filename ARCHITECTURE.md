# Arquitetura

API HTTP construída com Spring Boot 2.7, Spring MVC e Spring Data JPA. A conexão ao MySQL é externa ao processo da aplicação e configurada via `DB_URL`, `DB_USERNAME` e `DB_PASSWORD`. O build Maven compila os fontes em `src/main/java`, e a imagem Docker empacota o JAR para execução com JRE 17 e usuário não privilegiado.

A versão atual do Spring Boot é legada e exige planejamento de atualização e testes de regressão antes de uma migração maior.
