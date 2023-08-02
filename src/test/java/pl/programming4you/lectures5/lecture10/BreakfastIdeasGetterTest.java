package pl.programming4you.lectures5.lecture10;

import com.theokanning.openai.service.OpenAiService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class BreakfastIdeasGetterTest {
    @Test
    @DisplayName("Should throw CannotGetBreakfastIdeasException")
    public void testBreakfastIdeasGetterWhenCannotGetBreakfastIdeas() {
        String model = "testModel";
        BreakfastIdeasGetter breakfastIdeasGetter = new BreakfastIdeasGetter(new FileProductsReader("testPath"),
                new ChatGPTClient(new OpenAiService(model), model));
        assertThrows(CannotGetBreakfastIdeasException.class, breakfastIdeasGetter::getBreakfastIdeas);
    }
}