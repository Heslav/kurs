package pl.programming4you.lectures5.lecture10;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BreakfastIdeasGetterTest {
    @Test
    @DisplayName("Should throw exception when cannot get breakfast ideas")
    public void testGetBreakfastIdeasThrowsCannotGetBreakfastIdeasException() throws Exception {
        ProductsReader productsReader = mock(ProductsReader.class);
        LLMClient llmClient = mock(LLMClient.class);
        BreakfastIdeasGetter breakfastIdeasGetter = new BreakfastIdeasGetter(productsReader, llmClient);
        when(productsReader.readProducts()).thenThrow(new CannotReadProductsException("Cannot read products"));

        assertThrows(CannotGetBreakfastIdeasException.class, breakfastIdeasGetter::getBreakfastIdeas);
    }

    @Test
    @DisplayName("Should return breakfast idea")
    public void testBreakfastIdeasGetter() throws CannotReadProductsException, CannotGetBreakfastIdeasException {
        LLMClient llmClient = mock(LLMClient.class);
        ProductsReader productsReader = mock(ProductsReader.class);

        when(productsReader.readProducts()).thenReturn(List.of("egg", "apple"));
        String expected = "You can eat egg and apple.";
        when(llmClient.getBreakfastIdeas(any())).thenReturn(expected);

        BreakfastIdeasGetter breakfastIdeasGetter = new BreakfastIdeasGetter(productsReader, llmClient);
        assertEquals(expected, breakfastIdeasGetter.getBreakfastIdeas());
    }
}
