import java.util.Date;

abstract public class Book{
    protected Integer isbn;
    protected String title;
    protected String publishingHouse;
    protected Date publishingDate;
    protected String bookAuthor;

    public Integer getIsbn() {
        return isbn;
    }

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

    public Book(Integer isbn, String title, String publishingHouse, Date publishingDate, String bookAuthor) {
        this.isbn = isbn;
        this.title = title;
        this.publishingHouse = publishingHouse;
        this.publishingDate = publishingDate;
        this.bookAuthor = bookAuthor;
    }
}
