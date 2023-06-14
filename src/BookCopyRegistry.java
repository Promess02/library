import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Class of BookCopyRegistry
 */
public class BookCopyRegistry implements Registry, Serializable {
    private static final long serialVersionUID = 1L;
    private List<BookCopy> bookCopyList;

    /**
     * Default constructor that initiates
     * BookCopyList with a new instance of linked list
     */
    public BookCopyRegistry() {
        bookCopyList = new LinkedList<>();
    }

    /**
     * Adds book copy
     * @param title - title of the book
     * @param publishingHouse - name of publishing house
     * @param publishingDate - date of publishment
     * @param bookAuthor - author of the book
     * @param rentalStatus - rental status of the book (enum object - ORDERED, RENTED, AVAILABLE)
     * @param bookCategory - category of the book enum type of values (FANTASY, HORROR, SCIENCE_FICTION, ROMANCE, BIOGRAPHY, SCIENCE, ART)
     */
    public void addBookCopy(String title, String publishingHouse, Date publishingDate, String bookAuthor, RentalStatus rentalStatus, BookCategory bookCategory){
        BookCopy bookCopy = new BookCopy(title,publishingHouse,publishingDate, bookAuthor, bookCopyList.size()+1, rentalStatus, bookCategory);
        bookCopyList.add(bookCopy);
    }

    /**
     * Adds and returns book copy
     * @param title - title of the book
     * @param publishingHouse - name of publishing house
     * @param publishingDate - date of publishment
     * @param bookAuthor - author of the book
     * @param rentalStatus - rental status of the book of the book (enum object - ORDERED, RENTED, AVAILABLE)
     * @param bookCategory - category of the book enum type of values (FANTASY, HORROR, SCIENCE_FICTION, ROMANCE, BIOGRAPHY, SCIENCE, ART)
     * @return bookCopy
     */
    public BookCopy addBookCopyAndReturn(String title, String publishingHouse, Date publishingDate, String bookAuthor, RentalStatus rentalStatus, BookCategory bookCategory){
        BookCopy bookCopy = new BookCopy(title,publishingHouse,publishingDate, bookAuthor, bookCopyList.size()+1, rentalStatus, bookCategory);
        bookCopyList.add(bookCopy);
        return bookCopy;
    }

    /**
     * Returns list of copies if given status of the book copy e.g. ordered avaliable
     * @param rentalStatus - rental status of the book (enum object - ORDERED, RENTED, AVAILABLE)
     * @return copies
     */
    public LinkedList<BookCopy> getListOfCopiesGivenStatus(RentalStatus rentalStatus){
        LinkedList<BookCopy> copies = new LinkedList<>();
        for(BookCopy bookCopy: bookCopyList){
            if(bookCopy.getRentalStatus().equals(rentalStatus)) copies.add(bookCopy);
        }
        return copies;
    }

    /**
     * Returns list of copies if given category of the book copy e.g. (FANTASY, HORROR, SCIENCE_FICTION, ROMANCE, BIOGRAPHY, SCIENCE, ART)
     * @param bookCategory - category of the book enum type of values (FANTASY, HORROR, SCIENCE_FICTION, ROMANCE, BIOGRAPHY, SCIENCE, ART)
     * @return copies
     */
    public LinkedList<BookCopy> getListOfCopiesGivenCategory(BookCategory bookCategory){
        LinkedList<BookCopy> copies = new LinkedList<>();
        for(BookCopy bookCopy: bookCopyList){
            if(bookCopy.getBookCategory().equals(bookCategory)) copies.add(bookCopy);
        }
        return copies;
    }

    /**
     * If ID found returns book copy, else returns null
     * @param id - integer id of bookcopy
     * @return bookCopy or null
     */
    @Override
    public BookCopy getEntryById(Integer id) {
        for(BookCopy bookCopy: bookCopyList){
            if(bookCopy.getCatalogNumber().equals(id)) return bookCopy;
        }
        return null;
    }

    /**
     * Deletes bookcopy which ID was given
     * @param id - integer id of bookcopy
     */
    @Override
    public void deleteEntryById(Integer id) {
        bookCopyList.stream()
                .filter( bookCopy -> bookCopy.getCatalogNumber().equals(id))
                .findFirst()
                .ifPresent(rental -> bookCopyList.remove(rental));
    }

    /**
     * Check if listed object has id identical to given one
     * @param id  - integer id of bookcopy
     * @return true or false
     */
    @Override
    public boolean checkIfcontainsID(Integer id) {
        for(BookCopy bookCopy: bookCopyList){
            if(bookCopy.getCatalogNumber().equals(id)) return true;
        }
        return false;
    }

    /**
     * Returns registry of the book
     * @return string
     */
    @Override
    public String toString() {
        return "BookCopyRegistry: " +
                "bookCopyList=" + bookCopyList +
                '\n';
    }

}
