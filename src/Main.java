import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        ZoneId defaultZoneId = ZoneId.systemDefault();
        LocalDate localDate = LocalDate.now();
        java.util.Date dateNow = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

        RentalRegistry rentalRegistry = new RentalRegistry();
        BookCopyRegistry bookCopyRegistry = new BookCopyRegistry();
        ReaderRegistry readerRegistry = new ReaderRegistry();

        readerRegistry.addUser("Mikolaj","Michalczyk","miko2002","CipheredPassword");
        bookCopyRegistry.addBookCopy(12,"Mistborn","MAG", new Date(2020,5,21), "Brandon Sanderson", RentalStatus.ORDERED, BookCategory.FANTASY);
        rentalRegistry.addRental(readerRegistry.getEntryById(1),bookCopyRegistry.getEntryById(1),
                dateNow, Optional.ofNullable(null));

        System.out.println(rentalRegistry.getEntryById(1));
        System.out.println(bookCopyRegistry.getEntryById(1));
        System.out.println(readerRegistry.getEntryById(1));

    }
}