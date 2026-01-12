package org.example.controller;

import org.example.service.OpenAIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.Map;

/**
 * REST Controller for OpenAI chat endpoints
 */
@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private final OpenAIService openAIService;

    @Autowired
    public ChatController(OpenAIService openAIService) {
        this.openAIService = openAIService;
    }

    /**
     * Simple chat endpoint
     * POST /api/chat
     * Body: { "message": "Your question here" }
     */
    @PostMapping
    public Map<String, String> chat(@RequestBody Map<String, String> request) {
        String message = request.get("message");
        String response = openAIService.chat(message);
        return Map.of(
                "prompt", message,
                "response", response
        );
    }

    /**
     * Chat with system instructions
     * POST /api/chat/with-system
     * Body: { "systemMessage": "You are a helpful assistant", "userMessage": "Your question" }
     */
    @PostMapping("/with-system")
    public Map<String, String> chatWithSystem(@RequestBody Map<String, String> request) {
        String systemMessage = request.get("systemMessage");
        String userMessage = request.get("userMessage");
        String response = openAIService.chatWithSystem(systemMessage, userMessage);
        return Map.of(
                "systemMessage", systemMessage,
                "userMessage", userMessage,
                "response", response
        );
    }

    /**
     * Streaming chat endpoint (Server-Sent Events)
     * POST /api/chat/stream
     * Body: { "message": "Your question here" }
     */
    @PostMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> chatStream(@RequestBody Map<String, String> request) {
        String message = request.get("message");
        return openAIService.chatStream(message);
    }

    /**
     * Health check endpoint
     */
    @GetMapping("/health")
    public Map<String, String> health() {
        return Map.of("status", "UP", "service", "OpenAI Chat Service");
    }
}

