package example2;

import java.util.Date;

public class Book {
    private final String title;
    private final String author;
    private final int pages;
    private Date returnDate;

    public Book(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    public Date getReturnDate(){
        return this.returnDate;
    }

    public void setReturnDate(Date returnDate){
        this.returnDate = returnDate;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }

    @Override
    public String toString() {
        return String.format("%50s | %25s | %10s | %20s", this.title, this.author,
                this.pages, this.returnDate);
    }
}
