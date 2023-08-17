package pl.programming4you.lectures5.lecture11;

public class Task23 {
    public static void main(String[] args) {
        try {
            System.out.println(new IMDBClient(new JSONFormatValues(),
                    new FileTokenProvider("imdb.properties"), "").getYearOfMade());
        } catch (ConfigurationException e) {
            e.printStackTrace();
        } catch (CustomInterruptedException | InvalidMovieTitleException e) {
            throw new RuntimeException(e);
        }
    }
}
