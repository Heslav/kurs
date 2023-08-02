package pl.programming4you.lectures5.lecture10;

import com.theokanning.openai.completion.chat.ChatCompletionChoice;
import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.service.OpenAiService;

import java.util.List;
import java.util.stream.Collectors;

public class ChatGPTClient implements LLMClient {
    private final OpenAiService openAiService;
    private final String model;

    public ChatGPTClient(OpenAiService openAiService, String model) {
        this.openAiService = openAiService;
        this.model = model;
    }

    @Override
    public String getBreakfastIdeas(List<String> products) {
        if (products == null || products.isEmpty()) {
            throw new IllegalArgumentException("Products list is empty or null.");
        }
        return openAiService.createChatCompletion(
                        ChatCompletionRequest.builder()
                                .messages(List.of(new ChatMessage("user",
                                        "What can I eat for breakfast using these: " + String.join(", ", products))))
                                .model(model)
                                .build()
                ).getChoices().stream()
                .map(ChatCompletionChoice::getMessage)
                .map(ChatMessage::getContent)
                .collect(Collectors.joining());
    }
}
