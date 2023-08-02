package pl.programming4you.lectures5.lecture10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileProductsReader implements ProductsReader {
    private final String productsFilePath;

    public FileProductsReader(String productsFilePath) {
        this.productsFilePath = productsFilePath;
    }

    @Override
    public List<String> readProducts() throws CannotReadProductsException {
        try {
            return Files.readAllLines(Paths.get(productsFilePath));
        } catch (IOException e) {
            throw new CannotReadProductsException("Cannot read products. Make sure that file exists.", e);
        }
    }
}
