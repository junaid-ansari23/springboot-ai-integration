package org.example.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

/**
 * Service class for interacting with OpenAI GPT models
 */
@Service
public class OpenAIService {

    private final ChatClient chatClient;
    private final OpenAiChatModel chatModel;

    @Autowired
    public OpenAIService(OpenAiChatModel chatModel) {
        this.chatModel = chatModel;
        this.chatClient = ChatClient.create(chatModel);
    }

    /**
     * Send a simple prompt to GPT and get a response
     * @param prompt The user's prompt/question
     * @return The AI's response
     */
    public String chat(String prompt) {
        return chatClient.prompt()
                .user(prompt)
                .call()
                .content();
    }

    /**
     * Send a prompt with system instructions
     * @param systemMessage System instructions for the AI
     * @param userMessage The user's prompt/question
     * @return The AI's response
     */
    public String chatWithSystem(String systemMessage, String userMessage) {
        return chatClient.prompt()
                .system(systemMessage)
                .user(userMessage)
                .call()
                .content();
    }

    /**
     * Stream responses from GPT (useful for long responses)
     * @param prompt The user's prompt/question
     * @return A Flux stream of response chunks
     */
    public Flux<String> chatStream(String prompt) {
        return chatClient.prompt()
                .user(prompt)
                .stream()
                .content();
    }
}

