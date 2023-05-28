import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class BookCopyRegistry {
    private List<BookCopy> bookCopyList;

    public BookCopyRegistry() {
        bookCopyList = new LinkedList<>();
    }

    public void addBookCopy(Integer isbn, String title, String publishingHouse, Date publishingDate, String bookAuthor, RentalStatus rentalStatus){
        BookCopy bookCopy = new BookCopy(isbn, title,publishingHouse,publishingDate, bookAuthor, bookCopyList.size()+1, rentalStatus);
        bookCopyList.add(bookCopy);
    }
    public BookCopy getBookCopyByCatalogNumber(Integer bookCopyId){
        for(BookCopy bookCopy: bookCopyList){
            if(bookCopy.getCatalogNumber().equals(bookCopyId)) return bookCopy;
        }
        return null;
    }

    public void deleteBookCopy(Integer catalogNumber){
        bookCopyList.stream()
                .filter( bookCopy -> bookCopy.getCatalogNumber().equals(catalogNumber))
                .findFirst()
                .ifPresent(rental -> bookCopyList.remove(rental));
    }
    public BookCopy addBookCopyAndReturn(Integer isbn, String title, String publishingHouse, Date publishingDate, String bookAuthor, RentalStatus rentalStatus){
        BookCopy bookCopy = new BookCopy(isbn, title,publishingHouse,publishingDate, bookAuthor, bookCopyList.size()+1, rentalStatus);
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
}
