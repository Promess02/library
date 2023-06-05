import java.io.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Optional;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ZoneId defaultZoneId = ZoneId.systemDefault();
        LocalDate localDate = LocalDate.now();
        java.util.Date dateNow = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
        RegistryList registries = new RegistryList(new ArrayList<>());
        //The 3 registries used in the program
        RentalRegistry rentalRegistry;
        BookCopyRegistry bookCopyRegistry;
        ReaderRegistry readerRegistry;

        FileInputStream fileInputStream = new FileInputStream("registries.txt");
        ObjectInputStream objectInputStream;
        System.out.println(fileInputStream.available());

        if(fileInputStream.available()>0){
            objectInputStream = new ObjectInputStream(fileInputStream);
            registries = (RegistryList) objectInputStream.readObject();
            rentalRegistry = (RentalRegistry) registries.getRegistryList().get(0);
            readerRegistry = (ReaderRegistry) registries.getRegistryList().get(1);
            bookCopyRegistry = (BookCopyRegistry) registries.getRegistryList().get(2);

            objectInputStream.close();
        }
        else{
            registries.setRegistryList(new ArrayList<>());
            rentalRegistry = new RentalRegistry();
            bookCopyRegistry = new BookCopyRegistry();
            readerRegistry = new ReaderRegistry();

            registries.getRegistryList().add(rentalRegistry); //rzutowanie obiektu typu RentalRegistry na obiekt typu Registry
            registries.getRegistryList().add(readerRegistry); //rzutowanie obiektu typu ReaderRegistry na obiekt typu Registry
            registries.getRegistryList().add(bookCopyRegistry); //rzutowanie obiektu typu BookCopyRegistry na obiekt typu Registry
        }

//        readerRegistry.addUser("Mikolaj","Michalczyk","miko2002","CipheredPassword");
//        bookCopyRegistry.addBookCopy(12,"Mistborn","MAG", new Date(2020,5,21), "Brandon Sanderson", RentalStatus.ORDERED, BookCategory.FANTASY);
//        rentalRegistry.addRental(readerRegistry.getEntryById(1),bookCopyRegistry.getEntryById(1),
//                dateNow, Optional.empty());
        System.out.println(registries.getRegistryList().get(0).getEntryById(1)); //polimorficzne wywołanie metody getEntryById
        System.out.println(registries.getRegistryList().get(1).getEntryById(1));
        System.out.println(registries.getRegistryList().get(2).getEntryById(1));

        FileOutputStream fileOutputStream = new FileOutputStream("registries.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(registries);
        objectOutputStream.flush();
        objectOutputStream.close();
    }
}