import java.io.Serializable;
import java.util.Date;

public class BookCopy extends Book implements Serializable {
        private Integer catalogNumber;
        private RentalStatus rentalStatus;

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

        public void setRentalStatus(RentalStatus rentalStatus) {
                this.rentalStatus = rentalStatus;
        }

        public Integer getCatalogNumber() {
                return catalogNumber;
        }

        public RentalStatus getRentalStatus() {
                return rentalStatus;
        }

        public BookCopy(String title, String publishingHouse, Date publishingDate, String bookAuthor, Integer catalogNumber, RentalStatus rentalStatus, BookCategory bookCategory) {
                super(title, publishingHouse, publishingDate, bookAuthor, bookCategory);
                this.catalogNumber = catalogNumber;
                this.rentalStatus = rentalStatus;
        }
}
