package pl.programming4you.lectures5.lecture1;

public class Task4 {
    public static String checkStringLength(String randomText) {
        if (randomText == null || randomText.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (randomText.length() <= 7) {
            return "Your string is not too long";
        }
        return "Your string is quite long";
    }
}