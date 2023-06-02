import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class BookCopyRegistry implements Registry{
    private List<BookCopy> bookCopyList;

    public BookCopyRegistry() {
        bookCopyList = new LinkedList<>();
    }

    public void addBookCopy(Integer isbn, String title, String publishingHouse, Date publishingDate, String bookAuthor, RentalStatus rentalStatus, BookCategory bookCategory){
        BookCopy bookCopy = new BookCopy(isbn, title,publishingHouse,publishingDate, bookAuthor, bookCopyList.size()+1, rentalStatus, bookCategory);
        bookCopyList.add(bookCopy);
    }
    public BookCopy addBookCopyAndReturn(Integer isbn, String title, String publishingHouse, Date publishingDate, String bookAuthor, RentalStatus rentalStatus, BookCategory bookCategory){
        BookCopy bookCopy = new BookCopy(isbn, title,publishingHouse,publishingDate, bookAuthor, bookCopyList.size()+1, rentalStatus, bookCategory);
        bookCopyList.add(bookCopy);
        return bookCopy;
    }

    public LinkedList<BookCopy> getListOfCopiesGivenStatus(RentalStatus rentalStatus){
        LinkedList<BookCopy> copies = new LinkedList<>();
        for(BookCopy bookCopy: bookCopyList){
            if(bookCopy.getRentalStatus().equals(rentalStatus)) copies.add(bookCopy);
        }
        return copies;
    }
    public LinkedList<BookCopy> getListOfCopiesGivenStatus(BookCategory bookCategory){
        LinkedList<BookCopy> copies = new LinkedList<>();
        for(BookCopy bookCopy: bookCopyList){
            if(bookCopy.getBookCategory().equals(bookCategory)) copies.add(bookCopy);
        }
        return copies;
    }
    @Override
    public BookCopy getEntryById(Integer id) {
        for(BookCopy bookCopy: bookCopyList){
            if(bookCopy.getCatalogNumber().equals(id)) return bookCopy;
        }
        return null;
    }

    @Override
    public void deleteEntryById(Integer id) {
        bookCopyList.stream()
                .filter( bookCopy -> bookCopy.getCatalogNumber().equals(id))
                .findFirst()
                .ifPresent(rental -> bookCopyList.remove(rental));
    }


}
