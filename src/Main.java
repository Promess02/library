import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

/**
* Main class of the program.
*/
public class Main {

    /**
     * Entry point of the program.
     * @param args - program arguments
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws ParseException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException, ParseException {
        RegistryList registries = new RegistryList(new ArrayList<>());
        //The 3 registries used in the program
        RentalRegistry rentalRegistry;
        BookCopyRegistry bookCopyRegistry;
        ReaderRegistry readerRegistry;

        FileInputStream fileInputStream = new FileInputStream("registries.txt");
        if(fileInputStream.available()>0) System.out.println("found data");
        else System.out.println("data not found");

        ObjectInputStream objectInputStream;
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
        new Menu(registries);

    }
}