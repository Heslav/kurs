package pl.programming4you.lectures5.lecture10;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FileProductsReaderTest {
    @Test
    @DisplayName("Should return list of products from a test.txt file")
    public void testBreakfastIdeaFileProductsReader() throws CannotReadProductsException {
        FileProductsReader fileProductsReader = new FileProductsReader("src/test/resources/test.txt");
        assertEquals(List.of("egg", "apple"), fileProductsReader.readProducts());
    }

    @Test
    @DisplayName("Should throw CannotReadProductException when products file doesn't exist")
    public void testBreakfastIdeaFileProductsReaderWithoutFile() {
        FileProductsReader fileProductsReader = new FileProductsReader("src/test/resources/noFile.txt");
        assertThrows(CannotReadProductsException.class, fileProductsReader::readProducts);
    }
}