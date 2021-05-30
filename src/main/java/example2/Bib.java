package example2;

public class Bib {
    public static void main(String[] args) {
        Book book = new Book("Harry Potter und der Stein der Weisen", " Joanne K. Rowling", 336);
        Book book2 = new Book("Harry Potter und die Kammer des Schreckens", " Joanne K. Rowling", 455);
        Customer customer = new Customer("Nico");
        customer.rent(book);
        System.out.println(customer.showBooks());
        customer.rent(book2);
        System.out.println(customer.showBooks());
        System.out.println(customer.rentReturn(book));
        System.out.println(customer.showBooks());
    }
}