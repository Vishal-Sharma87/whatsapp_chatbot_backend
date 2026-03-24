# WhatsApp Chatbot Backend

A Spring Boot REST API assignment that simulates a basic WhatsApp-style chatbot. It receives an incoming message from the user and returns a predefined response based on the message content.

---

## Features

- Responds with `Hello!` when the user sends `Hi`
- Responds with `Goodbye!` when the user sends `Bye`
- Returns a default fallback message for any other input
- Returns `400 Bad Request` if the message field is null or missing

---

## Tech Stack

- **Language:** Java
- **Framework:** Spring Boot
- **Build Tool:** Maven

---

## API Reference

### `GET /receive/health`

Health check endpoint to verify the server is running.

#### Response

```
ok :)
```

---

### `POST /receive/webhook`

Accepts an incoming user message and returns the appropriate chatbot response.

#### Request Body

```json
{
  "message": "Hi"
}
```

#### Response Body (wrapped in `ApiResponseDto`)

```json
{
  "data": {
    "response": "Hello!"
  }
}
```

#### Response Examples

| Input Message          | HTTP Status       | Response (`data.response`)        |
|------------------------|-------------------|-----------------------------------|
| `Hi`                   | `200 OK`          | `Hello!`                          |
| `Bye`                  | `200 OK`          | `Goodbye!`                        |
| Any other text         | `200 OK`          | `Default message`                 |
| `null` / missing field | `400 Bad Request` | Validation error (via `@Valid`)   |

---

## Project Structure

```
whatsapp_chatbot_backend/
├── src/
│   └── main/
│       └── java/
│           └── com/example/chatbot/
│               ├── controllers/
│               │   └── ReceiveMessageController.java
│               ├── services/
│               │   └── ReceiveMessageService.java
│               └── dtos/
│                   ├── ContentRequestDto.java
│                   ├── ContentResponseDto.java
│                   └── ApiResponseDto.java
├── pom.xml
└── README.md
```

---

## How to Run

1. **Clone the repository**
   ```bash
   git clone https://github.com/your-username/whatsapp_chatbot_backend.git
   cd whatsapp_chatbot_backend
   ```

2. **Build the project**
   ```bash
   mvn clean install
   ```

3. **Run the application**
   ```bash
   mvn spring-boot:run
   ```

4. **Test the endpoints**
   ```bash
   # Health check
   curl http://localhost:8080/receive/health

   # Send a message
   curl -X POST http://localhost:8080/receive/webhook \
     -H "Content-Type: application/json" \
     -d '{"message": "Hi"}'
   ```

---

## Flow Diagram

```
User sends POST /receive/webhook
        │
        ▼
  message == null? (@Valid)
    ├── YES → 400 Bad Request
    └── NO
          │
          ▼
    message == "Hi"?
      ├── YES → ApiResponseDto { data: "Hello!" }
      └── NO
            │
            ▼
      message == "Bye"?
        ├── YES → ApiResponseDto { data: "Goodbye!" }
        └── NO → ApiResponseDto { data: "Default message" }
```

---

## Assignment Context

This project is part of a backend development assignment demonstrating:
- REST API design with Spring Boot
- Request validation and error handling
- Conditional business logic / message routing
