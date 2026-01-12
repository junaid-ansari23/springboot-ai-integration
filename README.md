# Spring AI OpenAI Integration

This Spring Boot application demonstrates integration with OpenAI GPT models using Spring AI.

## Setup

### 1. Configure your OpenAI API Key

You can set your OpenAI API key in one of the following ways:

**Option A: Environment Variable (Recommended)**
```bash
# Windows PowerShell
$env:OPENAI_API_KEY="your-actual-api-key-here"

# Windows CMD
set OPENAI_API_KEY=your-actual-api-key-here
```

**Option B: application.properties**
Edit `src/main/resources/application.properties` and replace `your-api-key-here` with your actual API key.

### 2. Build the project
```bash
mvn clean install
```

### 3. Run the application
```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

## API Endpoints

### 1. Simple Chat
Send a message to GPT and get a response.

```bash
POST http://localhost:8080/api/chat
Content-Type: application/json

{
  "message": "What is Spring Boot?"
}
```

### 2. Chat with System Instructions
Send a message with custom system instructions.

```bash
POST http://localhost:8080/api/chat/with-system
Content-Type: application/json

{
  "systemMessage": "You are a helpful Java programming expert",
  "userMessage": "Explain dependency injection"
}
```

### 3. Streaming Chat
Get streaming responses (useful for long answers).

```bash
POST http://localhost:8080/api/chat/stream
Content-Type: application/json

{
  "message": "Write a long story about a programmer"
}
```

### 4. Health Check
```bash
GET http://localhost:8080/api/chat/health
```

## Configuration

Edit `src/main/resources/application.properties` to customize:

- **Model**: Change `spring.ai.openai.chat.options.model` (gpt-4, gpt-3.5-turbo, etc.)
- **Temperature**: Adjust `spring.ai.openai.chat.options.temperature` (0.0 to 2.0)
- **Port**: Change `server.port`

## Testing with cURL

```bash
# Simple chat
curl -X POST http://localhost:8080/api/chat ^
  -H "Content-Type: application/json" ^
  -d "{\"message\": \"Hello, GPT!\"}"

# Chat with system message
curl -X POST http://localhost:8080/api/chat/with-system ^
  -H "Content-Type: application/json" ^
  -d "{\"systemMessage\": \"You are a poet\", \"userMessage\": \"Write a haiku about code\"}"
```

## Dependencies

- **Spring Boot 3.2.1**
- **Spring AI 1.0.0-M4** (OpenAI integration)
- **Java 21**

## Get Your OpenAI API Key

1. Visit https://platform.openai.com/
2. Sign up or log in
3. Go to API Keys section
4. Create a new secret key
5. Copy and use it in this application

