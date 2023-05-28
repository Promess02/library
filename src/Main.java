import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        RentalRegistry rentalRegistry = new RentalRegistry();
        BookCopyRegistry bookCopyRegistry = new BookCopyRegistry();
        ReaderRegistry readerRegistry = new ReaderRegistry();

        readerRegistry.addUser("Mikolaj","Michalczyk","miko2002","szyfrowaneHaslo");
        bookCopyRegistry.addBookCopy(12,"Miasto Jadeitu","Wydawnictwo MAG", new Date(2020,5,21), "Fonda Lee", RentalStatus.ORDERED);
        rentalRegistry.addRental(readerRegistry.getReaderById(1),bookCopyRegistry.getBookCopyByCatalogNumber(1),
                Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()), Optional.ofNullable(null));

        System.out.println(rentalRegistry.getRentalById(1));

    }
}