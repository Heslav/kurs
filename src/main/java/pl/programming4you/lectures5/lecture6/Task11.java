package pl.programming4you.lectures5.lecture6;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Task11 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(Path.of(args[0]))) {
            String line;
            String longestLine = "";
            while ((line = reader.readLine()) != null) {
                if (line.length() > longestLine.length()) {
                    longestLine = line;
                }
            }
            System.out.println(longestLine);
        }
    }
}

