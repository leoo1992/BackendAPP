# BackendAPP

API Java com Spring Boot, Spring Data JPA e MySQL.

## Pré-requisitos

- JDK 17 e Maven ou Maven Wrapper
- MySQL acessível

## Configuração

Configure `DB_URL`, `DB_USERNAME` e `DB_PASSWORD` no ambiente. Consulte `.env.example` como modelo; o Spring Boot não lê automaticamente arquivos `.env`.

## Executar

```bash
./mvnw spring-boot:run
```

## Verificação

```bash
./mvnw test
./mvnw package
```

## Docker

```bash
docker build -t backendapp .
docker run --rm -p 8080:8080 -e DB_URL='jdbc:mysql://host.docker.internal:3306/mydatabase?useSSL=false' -e DB_USERNAME=root -e DB_PASSWORD='configure-localmente' backendapp
```

Use segredos somente por variáveis de ambiente ou um gerenciador de segredos; não faça commit de credenciais.
