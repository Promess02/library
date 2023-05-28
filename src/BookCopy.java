import java.util.Date;

public class BookCopy extends Book{
        private Integer catalogNumber;
        private RentalStatus rentalStatus;

        public void setRentalStatus(RentalStatus rentalStatus) {
                this.rentalStatus = rentalStatus;
        }

        public Integer getCatalogNumber() {
                return catalogNumber;
        }

        public RentalStatus getRentalStatus() {
                return rentalStatus;
        }

        public BookCopy(Integer isbn, String title, String publishingHouse, Date publishingDate, String bookAuthor, Integer catalogNumber, RentalStatus rentalStatus) {
                super(isbn, title, publishingHouse, publishingDate, bookAuthor);
                this.catalogNumber = catalogNumber;
                this.rentalStatus = rentalStatus;
        }
}
