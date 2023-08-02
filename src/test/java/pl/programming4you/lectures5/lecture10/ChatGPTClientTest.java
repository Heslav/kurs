package pl.programming4you.lectures5.lecture10;

import com.theokanning.openai.completion.chat.ChatCompletionChoice;
import com.theokanning.openai.completion.chat.ChatCompletionResult;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.service.OpenAiService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class ChatGPTClientTest {
    @Test
    @DisplayName("Should return breakfast idea as a String")
    public void testGetBreakfastIdeas() {

        OpenAiService openAiService = mock(OpenAiService.class);
        String model = "testModel";

        ChatMessage chatMessage = new ChatMessage();
        String chatMessageContent = "You can make an omelette";
        chatMessage.setContent(chatMessageContent);

        ChatCompletionChoice chatCompletionChoice = new ChatCompletionChoice();
        chatCompletionChoice.setMessage(chatMessage);

        ChatCompletionResult chatCompletionResult = new ChatCompletionResult();
        chatCompletionResult.setChoices(List.of(chatCompletionChoice));

        when(openAiService.createChatCompletion(argThat(chatCompletionRequest ->
                chatCompletionRequest.getModel().equals(model)))).thenReturn(chatCompletionResult);
        ChatGPTClient chatGPTClient = new ChatGPTClient(openAiService, model);

        String result = chatGPTClient.getBreakfastIdeas(List.of("egg"));
        assertEquals(chatMessage.getContent(), result);
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when products list is null")
    public void testBreakfastIdeaWithNullProductsList() {
        assertThrows(IllegalArgumentException.class, () -> new ChatGPTClient(new OpenAiService("testToken"),
                "testModel").getBreakfastIdeas(null));
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when products list is empty")
    public void testBreakfastIdeaWithEmptyProductsList() {
        assertThrows(IllegalArgumentException.class, () -> new ChatGPTClient(new OpenAiService("testToken"),
                "testModel").getBreakfastIdeas(List.of()));
    }
}
