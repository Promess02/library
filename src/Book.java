import java.io.Serializable;
import java.util.Date;

abstract public class Book implements Serializable {
    protected String title;
    protected String publishingHouse;
    protected Date publishingDate;
    protected String bookAuthor;

    protected BookCategory bookCategory;

    public String getTitle() {
        return title;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public Date getPublishingDate() {
        return publishingDate;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public BookCategory getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(BookCategory bookCategory) {
        this.bookCategory = bookCategory;
    }

    public Book(String title, String publishingHouse, Date publishingDate, String bookAuthor, BookCategory bookCategory) {
        this.title = title;
        this.publishingHouse = publishingHouse;
        this.publishingDate = publishingDate;
        this.bookAuthor = bookAuthor;
        this.bookCategory = bookCategory;
    }
}
