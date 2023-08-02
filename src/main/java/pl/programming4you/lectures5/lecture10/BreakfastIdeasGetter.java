package pl.programming4you.lectures5.lecture10;

public class BreakfastIdeasGetter {
    public final ProductsReader productsReader;
    public final LLMClient llmClient;

    public BreakfastIdeasGetter(ProductsReader productsReader, LLMClient llmClient) {
        this.productsReader = productsReader;
        this.llmClient = llmClient;
    }

    public String getBreakfastIdeas() throws CannotGetBreakfastIdeasException {
        try {
            return llmClient.getBreakfastIdeas(productsReader.readProducts());
        } catch (CannotReadProductsException e) {
            throw new CannotGetBreakfastIdeasException("Couldn't load breakfast ideas.", e);
        }
    }
}
