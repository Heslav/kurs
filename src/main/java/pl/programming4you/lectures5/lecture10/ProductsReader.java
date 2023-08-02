package pl.programming4you.lectures5.lecture10;

import java.util.List;

public interface ProductsReader {
    List<String> readProducts() throws CannotReadProductsException;
}
