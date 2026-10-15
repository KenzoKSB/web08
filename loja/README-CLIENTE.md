# Dominio Cliente - exemplo web08

Foi adicionada a entidade `Cliente` e o controller `ClienteController` ao projeto Spring Boot da aula.

## Campos do Cliente
- `codigo`: identificador gerado automaticamente no POST
- `nome`: nome do cliente
- `email`: e-mail do cliente
- `telefone`: telefone do cliente

## Endpoints

| Metodo | URL | Funcao |
|---|---|---|
| GET | `/api/cliente` | Lista todos os clientes |
| GET | `/api/cliente/{codigo}` | Consulta um cliente pelo codigo |
| POST | `/api/cliente` | Cadastra um cliente |
| PUT | `/api/cliente/{codigo}` | Atualiza um cliente existente |
| DELETE | `/api/cliente/{codigo}` | Exclui um cliente |

## Exemplo de corpo JSON para POST e PUT

```json
{
  "nome": "Kenzo",
  "email": "kenzo@email.com",
  "telefone": "11999999999"
}
```

## Como executar

1. Abra a pasta `loja` no VS Code ou em outra IDE.
2. Execute `./mvnw spring-boot:run` no Linux/macOS ou `mvnw.cmd spring-boot:run` no Windows.
3. Teste os endpoints em uma ferramenta como Postman ou Insomnia, ou usando `curl`.

Os dados ficam em memoria e sao perdidos quando a aplicacao reinicia, pois o exemplo nao usa banco de dados.
