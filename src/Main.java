import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, ParseException {
        Date dateNow = Utils.getDateNow();
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

            objectInputStream.close();
        }
        else{
            registries.setRegistryList(new ArrayList<>());
            rentalRegistry = new RentalRegistry();
            bookCopyRegistry = new BookCopyRegistry();
            readerRegistry = new ReaderRegistry();
            registries.setRentalRegistry(rentalRegistry);
            registries.setReaderRegistry(readerRegistry);
            registries.setBookCopyRegistry(bookCopyRegistry);

        }
        Menu menu = new Menu(registries);

    }
}