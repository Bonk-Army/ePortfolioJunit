package example2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Customer {
    private String name;
    private List<Book> rentedBooks;

    public Customer(String name) {
        this.name = name;
        this.rentedBooks = new ArrayList<>();
    }

    public Customer(String name, List books) {
        this.name = name;
        this.rentedBooks = books;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBooks() {
        return rentedBooks;
    }

    public void rent(Book book) {
        long miliseconds = System.currentTimeMillis();
        miliseconds += 14 * 24 * 60 * 60 * 1000;
        book.setReturnDate(new Date(miliseconds));
        rentedBooks.add(book);
    }

    public String rentReturn(Book book) {
        Date date = new Date();
        if (book.getReturnDate().after(date)) {
            rentedBooks.remove(book);
            return "Das Buch wurde erfrolgreich zurückgegeben";
        }
        int days = (int) (date.getTime() - book.getReturnDate().getTime())/24/60/60/1000;
        return "Das Buch wurde " + days +" Tage zu spät zurückgegeben. " + (days * 0.35) + "€ Strafe sind fällig.";
    }

    public String showBooks() {
        StringBuilder allBooks = new StringBuilder();
        allBooks.append(String.format("%50s | %25s | %10s | %20s", "Book", "Author", "Pages", "Date"));
        allBooks.append("\n");
        allBooks.append(
                "----------------------------------------------------------------------------------------------------------------------------------");
        allBooks.append("\n");
        for (Book book : rentedBooks) {
            allBooks.append(String.format("%50s | %25s | %10s | %20s", book.getTitle(), book.getAuthor(),
                    book.getPages(), book.getReturnDate()));
            allBooks.append("\n");
        }
        return allBooks.toString();
    }
}
