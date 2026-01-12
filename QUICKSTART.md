# Quick Start Guide

## ✅ Setup Complete!

Your Spring Boot application with OpenAI integration has been successfully configured.

## 📦 What's Included

### Dependencies Added:
- **Spring Boot 3.2.1** - Core framework
- **Spring AI 1.0.0-M4** - OpenAI integration
- **Spring Web** - REST API support

### Files Created:
- `Main.java` - Spring Boot application entry point
- `OpenAIService.java` - Service for OpenAI interactions
- `ChatController.java` - REST API endpoints
- `application.properties` - Configuration file
- `README.md` - Complete documentation

## 🚀 Next Steps

### 1. Set Your OpenAI API Key

**Option A: Environment Variable (Recommended)**
```powershell
$env:OPENAI_API_KEY="sk-your-actual-api-key-here"
```

**Option B: application.properties**
Edit `src/main/resources/application.properties` and replace:
```
spring.ai.openai.api-key=your-api-key-here
```

### 2. Run the Application

In IntelliJ IDEA:
- Right-click on `Main.java`
- Select "Run 'Main.main()'"

Or use Maven:
```powershell
mvn spring-boot:run
```

### 3. Test the API

Once running, test with:
```powershell
curl -X POST http://localhost:8080/api/chat `
  -H "Content-Type: application/json" `
  -d '{"message": "Hello, GPT!"}'
```

## 📍 API Endpoints

All endpoints are documented in `README.md`. Key endpoints:

- `POST /api/chat` - Simple chat
- `POST /api/chat/with-system` - Chat with system instructions
- `POST /api/chat/stream` - Streaming responses
- `GET /api/chat/health` - Health check

## 🔑 Get Your OpenAI API Key

1. Visit https://platform.openai.com/api-keys
2. Sign in or create an account
3. Click "Create new secret key"
4. Copy and use the key

## 🎯 IntelliJ IDEA Integration

IntelliJ may take a moment to index the new dependencies. If you see red underlines:
1. Right-click on `pom.xml`
2. Select "Maven" → "Reload project"
3. Wait for indexing to complete

## 📖 Learn More

Check out:
- Spring AI Documentation: https://docs.spring.io/spring-ai/reference/
- OpenAI API Reference: https://platform.openai.com/docs/api-reference
- Spring Boot Guide: https://spring.io/guides

## 🐛 Troubleshooting

**Dependencies not resolved?**
- Reload Maven project in IntelliJ
- Check internet connection
- Try: `mvn clean install`

**API Key not working?**
- Verify the key starts with `sk-`
- Check for trailing spaces
- Ensure billing is enabled on OpenAI account

**Port 8080 already in use?**
- Change port in `application.properties`:
  ```
  server.port=8081
  ```

---

Happy coding! 🎉

