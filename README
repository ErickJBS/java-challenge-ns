
# Java Challenge

API REST acortadora de URLs creada con Spring Boot como parte del Java Challenge de Nearsoft.

## Instalación

Para correr el proyecto se puede ejecutar en una terminal:
```bash
mvn spring-boot:run
```
O alternativamente usar:
```bash
mvn clean install
```
```bash
java -jar target/shortener-0.0.1-SNAPSHOT.jar
```

## API Endpoints
| Endpoint | Method | Body Payload | Response |
|---|---|---|---|
| localhost:8080/ | POST | `{ "url": "http://mysite.com/" }` | `{ "alias": "{alias}" }` |
| localhost:8080/{alias} | GET | | *redireccionamiento a la URL destino* |
