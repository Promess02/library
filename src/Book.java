import java.io.Serializable;
import java.util.Date;

/**
 * Abstract class of Book
 */
abstract public class Book implements Serializable {
    protected String title;
    protected String publishingHouse;
    protected Date publishingDate;
    protected String bookAuthor;

    protected BookCategory bookCategory;


    /**
     * Returns title of the book
     * @return string
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns name of a publishing House
     * @return string
     */
    public String getPublishingHouse() {
        return publishingHouse;
    }

    /**
     * Returns date of publishment
     * @return date
     */
    public Date getPublishingDate() {
        return publishingDate;
    }

    /**
     * Returns author of the book
     * @return string
     */
    public String getBookAuthor() {
        return bookAuthor;
    }

    /**
     * Returns category of the book
     * @return BookCategory enum type of values (FANTASY, HORROR, SCIENCE_FICTION, ROMANCE, BIOGRAPHY, SCIENCE, ART)
     */
    public BookCategory getBookCategory() {
        return bookCategory;
    }

    /**
     * Sets category of the book
     * @param bookCategory consists enum type of values (FANTASY, HORROR, SCIENCE_FICTION, ROMANCE, BIOGRAPHY, SCIENCE, ART)
     */
    public void setBookCategory(BookCategory bookCategory) {
        this.bookCategory = bookCategory;
    }

    /**
     * Class constructor
     * @param title - title of the book
     * @param publishingHouse - name of publishing house
     * @param publishingDate - date of publishment
     * @param bookAuthor - author of the book
     * @param bookCategory - category of the book enum type of values (FANTASY, HORROR, SCIENCE_FICTION, ROMANCE, BIOGRAPHY, SCIENCE, ART)
     */
    public Book(String title, String publishingHouse, Date publishingDate, String bookAuthor, BookCategory bookCategory) {
        this.title = title;
        this.publishingHouse = publishingHouse;
        this.publishingDate = publishingDate;
        this.bookAuthor = bookAuthor;
        this.bookCategory = bookCategory;
    }
}
