package pl.programming4you.lectures5.lecture10;

import com.theokanning.openai.service.OpenAiService;

import java.util.Properties;

public class Task20Main {
    public static void main(String[] args) {
        try {
            Properties properties = new FilePropertiesProvider("gpt.properties").readProperties();
            System.out.println(new BreakfastIdeasGetter(new FileProductsReader("src/main/resources/products.txt"),
                    new ChatGPTClient(new OpenAiService(properties.getProperty("token")), properties.getProperty("model")))
                    .getBreakfastIdeas());
        } catch (ConfigurationException e) {
            e.printStackTrace();
        } catch (CannotGetBreakfastIdeasException e) {
            throw new RuntimeException(e);
        }
    }
}
