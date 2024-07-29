import java.util.ArrayList;
import java.util.List;

public class Person implements Borrowable{
    private String name;
    private int age;
    private List<Book> books;
    public Person(String name) {
        this.name = name;
        this.books = new ArrayList<Book>();
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(Book book) {
        this.books.add(book);
        book.setCounter(1);
    }

    public int getListLength (){
        return this.books.size();
    }

    public void borrowItem(Book book){
        System.out.println("book is borrow");
        book.setCounter(1);
    }
    public void returnItem(Book book){
        System.out.println("book is return");
        book.setCounter(0);
    }
}
