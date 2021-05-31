package example2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookTest {
    Book book;

    @BeforeEach
    void setUp() {
        book = new Book("Scythe - Die Hüter des Todes", "Neal Shusterman", 528);
    }

    @Test
    void getTitle() {
        assertEquals("Scythe - Die Hüter des Todes", book.getTitle());
    }

    @Test
    void getAuthor() {
        assertEquals("Neal Shusterman", book.getAuthor());
    }

    @Test
    void getPages() {
        assertEquals(528, book.getPages());
    }
}