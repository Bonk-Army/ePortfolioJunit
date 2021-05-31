package example2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerTest {
    Customer customer;
    Customer customer2;
    Book book;
    Book book2;
    List<Book> books;

    @BeforeEach
    void setUp() {
        books = new ArrayList<>();
        book = new Book("Erebos", "Ursula Poznanski", 488);
        book2 = new Book("Erebos 2", "Ursula Poznanski", 512);

        customer = new Customer("Paddy");
        long miliseconds = new Date().getTime();
        books.add(book);
        book.setReturnDate(new Date(miliseconds - 15 * 24 * 60 * 60 * 1000));
        books.add(book2);
        book2.setReturnDate(new Date(miliseconds + 14 * 24 * 60 * 60 * 1000));
        customer2 = new Customer("Lorenz", books);
    }

    @Test
    void getName() {
        assertEquals("Paddy", customer.getName());
    }

    @Test
    void getBooks() {
        customer.rent(book);
        customer.rent(book2);
        assertEquals(books, customer.getBooks());
    }

    @Test
    void rent() {
        customer.rent(book);
        assertTrue(customer.getBooks().contains(book));
    }

    @Test
    void rentReturn() {
        customer2.rentReturn(book2);
        assertFalse(customer.getBooks().contains(book2));
    }

    @Test
    void rentReturnPositive() {
        customer.rent(book2);
        assertEquals("Das Buch wurde erfrolgreich zurückgegeben", customer.rentReturn(book2));
    }

    @Test
    void rentReturnNegative() {
        assertEquals("Das Buch wurde 15 Tage zu spät zurückgegeben. 5.25€ Strafe sind fällig.", customer2.rentReturn(book));
    }

    @Test
    void showBooks() {
        assertEquals(buildBookTable(), customer2.showBooks());
    }

    String buildBookTable(){
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%50s | %25s | %10s | %20s", "Book", "Author", "Pages", "Date"));
        builder.append("\n");
        builder.append(
                "----------------------------------------------------------------------------------------------------------------------------------");
        for (Book book: books){
            builder.append("\n");
            builder.append(book.toString());
        }
        builder.append("\n");
        return builder.toString();
    }
}