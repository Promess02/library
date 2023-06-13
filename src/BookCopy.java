import java.io.Serializable;
import java.util.Date;

/**
 * Class of BookCopy
 */
public class BookCopy extends Book implements Serializable {
        private Integer catalogNumber;
        private RentalStatus rentalStatus;

        /**
         * Returns different informations about books
         * @return string
         */
        @Override
        public String toString() {
                return "BookCopy{" +
                        "catalogNumber=" + catalogNumber +
                        ", rentalStatus=" + rentalStatus +
                        ", title='" + title + '\'' +
                        ", publishingHouse='" + publishingHouse + '\'' +
                        ", publishingDate=" + publishingDate +
                        ", bookAuthor='" + bookAuthor + '\'' +
                        ", bookCategory=" + bookCategory +
                        '}';
        }

        /**
         * Sets rental status of the book
         * @param rentalStatus - rental status of the book (enum object - ORDERED, RENTED, AVAILABLE)
         */
        public void setRentalStatus(RentalStatus rentalStatus) {
                this.rentalStatus = rentalStatus;
        }

        /**
         * Returns catalog number of the book
         * @return Integer
         */
        public Integer getCatalogNumber() {
                return catalogNumber;
        }

        /**
         * Returns rental status of the book
         * @return RentalStatus
         */
        public RentalStatus getRentalStatus() {
                return rentalStatus;
        }

        /**
         * Class constructor
         * @param title - title of the book
         * @param publishingHouse - name of publishing house
         * @param publishingDate - date of publishment
         * @param bookAuthor - author of the book
         * @param catalogNumber - catalog number of the book
         * @param rentalStatus - rental status of the book of the book (enum object - ORDERED, RENTED, AVAILABLE)
         * @param bookCategory - category og the book enum type of values (FANTASY, HORROR, SCIENCE_FICTION, ROMANCE, BIOGRAPHY, SCIENCE, ART)
         */
        public BookCopy(String title, String publishingHouse, Date publishingDate, String bookAuthor, Integer catalogNumber, RentalStatus rentalStatus, BookCategory bookCategory) {
                super(title, publishingHouse, publishingDate, bookAuthor, bookCategory);
                this.catalogNumber = catalogNumber;
                this.rentalStatus = rentalStatus;
        }
}
