package pl.programming4you.lectures5.lecture11;

public class Task23 {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: Task23.jar imdbToken movieName");
            return;
        }
        try {
            System.out.println(new IMDBClient(new MovieDetailsJSONMapper(), args[0]).getReleaseYear(args[1]));
        } catch (NullPointerException | CannotGetMovieInfoException e) {
            System.err.println("Cannot get movie info.");
            e.printStackTrace();
        }
    }
}
