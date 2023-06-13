import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Menu {
    RegistryList registryList;

    public Menu(RegistryList registryList) throws IOException, ParseException {
        this.registryList = registryList;
        Scanner scanner = new Scanner(System.in);
        String response = "";

        while (true) {
            showEnterPrompt();
            response = scanner.nextLine();
            if (response.equals("quit")) break;
            switch (response) {
                case "ReaderConfig", "1" -> {
                    while (true) {
                        showReaderConfigPrompt();
                        response = scanner.nextLine();
                        if (response.equals("quit") || response.equals("8")) break;
                        switch (response) {
                            case "showReaders", "1" -> System.out.println(registryList.getReaderRegistry());
                            case "addReader", "2" -> addReader();
                            case "updatePassword", "3" -> updatePassword();
                            case "showReader", "4" -> showReader();
                            case "deleteReader", "5" -> deleteReader();
                            case "showReadersBooks", "6" -> showReadersBooks();
                            case "showReaderBooks", "7" -> showReaderBooks();
                            default -> System.out.println("Invalid command. Enter one of the proper commands");
                        }
                    }

                }
                case "BookCopiesConfig", "2" -> {
                    while (true) {
                        showBookCopyConfigPrompt();
                        response = scanner.nextLine();
                        if (response.equals("quit") || response.equals("7")) break;
                        switch (response) {
                            case "showBookCopies", "1" -> System.out.println(registryList.getBookCopyRegistry());
                            case "addBookCopy", "2" -> addBookCopy();
                            case "deleteBookCopy", "3" -> deleteBookCopy();
                            case "showBookCopy", "4" -> showBookCopy();
                            case "showBookCopiesGivenStatus", "5" -> showBookCopiesGivenStatus();
                            case "showBookCopiesGivenCategory", "6" -> showBookCopiesGivenCategory();
                            default -> System.out.println("Invalid command. Enter one of the proper commands");
                        }
                    }

                }
                case "RentalsConfig", "3" -> {
                    while (true) {
                        showRentalsConfigPrompt();
                        response = scanner.nextLine();
                        if (response.equals("quit") || response.equals("7")) break;
                        switch (response) {
                            case "showRentals", "1" -> System.out.println(registryList.getRentalRegistry());
                            case "addRental", "2" -> addRental();
                            case "updateDateOfReturn", "3" -> updateDateOfReturn();
                            case "showRental", "4" -> showRental();
                            case "showPenalty", "5" -> showPenalty();
                            case "showOverdueRentals", "6" -> System.out.println(registryList.getRentalRegistry().getListOfOverdueRentals());

                            default -> System.out.println("Not valid command. Enter one of the proper commands");
                        }
                    }
                }
                default -> System.out.println("Not valid command. Enter one of the proper commands");
            }
        }
        saveRegistryList();

    }

    private void showEnterPrompt() {
        System.out.println("Welcome to the library system. Use one of the following commands to make changes:");
        System.out.println("1. ReaderConfig - enter Reader config");
        System.out.println("2. BookCopiesConfig - enter BookCopies config");
        System.out.println("3. RentalsConfig - enter Rentals config");
        System.out.println("4. quit - exits the config modes and saves changes");
    }

    private void showReaderConfigPrompt() {
        System.out.println("Welcome to Reader Registry config. Enter one of the following commands");
        System.out.println("1. showReaders - prints all readers");
        System.out.println("2. addReader - adds a reader");
        System.out.println("3. updatePassword - updates a password");
        System.out.println("4. showReader - shows a reader given reader id");
        System.out.println("5. deleteReader - deletes a reader given reader id and reader password");
        System.out.println("6. showReadersBooks - shows books rented by all readers");
        System.out.println("7. showReaderBooks - shows books rented by a reader");
        System.out.println("8. quit - quits ReaderConfig");
    }

    private void showBookCopyConfigPrompt() {
        System.out.println("Welcome to BookCopy Registry config. Enter one of the following commands");
        System.out.println("1. showBookCopies - prints all book copies");
        System.out.println("2. addBookCopy - adds a book copy");
        System.out.println("3. deleteBookCopy - deletes a book copy");
        System.out.println("4. showBookCopy - shows a book copy given id");
        System.out.println("5. showBookCopiesGivenStatus - shows book copies provided their status");
        System.out.println("6. showBookCopiesGivenCategory - shows book copies provided their category");
        System.out.println("7. quit - quits BookCopyConfig");
    }

    private void showRentalsConfigPrompt() {
        System.out.println("Welcome to Rentals Registry config. Enter one of the following commands");
        System.out.println("1. showRentals - prints all Rentals");
        System.out.println("2. addRental - adds a rental");
        System.out.println("3. updateDateOfReturn - updates a date of return given rental id");
        System.out.println("4. showRental- shows a rental given id");
        System.out.println("5. showPenalty - shows penalty for a rental given rental status");
        System.out.println("6. showOverdueRentals - shows overdue rentals");
        System.out.println("7. quit - quits RentalsConfig");
    }

    private void addReader() {
        String name, surname, login, password;
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter name:");
            name = scanner.nextLine();
            System.out.println("Enter surname: ");
            surname = scanner.nextLine();
            System.out.println("Enter login: ");
            login = scanner.nextLine();
            System.out.println("Enter password: ");
            password = scanner.nextLine();
            registryList.getReaderRegistry().addUser(name, surname, login, password);
        } catch (Exception e) {
            System.out.println("Invalid input while adding reader");
        }
    }

    private void addBookCopy() throws ParseException {
        String title, publishingHouse, bookAuthor, rentalStatus, bookCategory, publishingDate;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter title: ");
        title = scanner.nextLine();
        System.out.println("Enter publishing House: ");
        publishingHouse = scanner.nextLine();
        System.out.println("Enter the author: ");
        bookAuthor = scanner.nextLine();
        // todo() - while loop until proper date format
        System.out.println("Enter the date of publishing in format YYYY-MM-DD: ");
        publishingDate = scanner.nextLine();
        while (true) {
            System.out.println("Enter one of the following statuses: ");
            for (RentalStatus rentalStatus1 : RentalStatus.values()) {
                System.out.println(rentalStatus1.name());
            }
            rentalStatus = scanner.nextLine();
            if (checkIfStringInputEqualsRentalStatusValue(rentalStatus)) {
                break;
            } else System.out.println("give a valid status");
        }
        while (true) {
            System.out.println("Enter one of the following categories: ");
            for (BookCategory bookCategory1 : BookCategory.values()) {
                System.out.println(bookCategory1.name());
            }
            bookCategory = scanner.nextLine();
            if (checkIfStringInputEqualsBookCategoryValue(bookCategory)) {
                break;
            } else System.out.println("give a valid book category");
        }

        registryList.getBookCopyRegistry().addBookCopy(title, publishingHouse,
                Utils.parseDate(publishingDate), bookAuthor, RentalStatus.valueOf(rentalStatus), BookCategory.valueOf(bookCategory));
    }

    private void addRental() {

        Scanner scanner = new Scanner(System.in);
        Integer readerId, bookCopyId, timeOfRental;
        Reader rentalReader;
        BookCopy rentalBookCopy;
        try {
            System.out.println("Enter reader id ");
            readerId = checkIfRegistryContainsId(registryList.getReaderRegistry());
            System.out.println("Enter book copy id");
            bookCopyId = checkIfRegistryContainsId(registryList.getBookCopyRegistry());
            System.out.println("Enter time of rental (months), penalty: " + Utils.penaltyForMonth + "/month");
            timeOfRental = scanner.nextInt();
            rentalReader = registryList.getReaderRegistry().getEntryById(readerId);
            rentalBookCopy = registryList.getBookCopyRegistry().getEntryById(bookCopyId);
            registryList.getRentalRegistry().addRental(rentalReader, rentalBookCopy, Utils.getDateNow(), timeOfRental);
        } catch (Exception e) {
            System.out.println("Invalid input while adding rental");
        }

    }

    private boolean checkIfStringInputEqualsRentalStatusValue(String string) {
        for (RentalStatus rentalStatus : RentalStatus.values()) {
            if (string.equals(rentalStatus.name())) return true;
        }
        return false;
    }

    private boolean checkIfStringInputEqualsBookCategoryValue(String string) {
        for (BookCategory bookCategory : BookCategory.values()) {
            if (string.equals(bookCategory.name())) return true;
        }
        return false;
    }

    private void updatePassword() {
        Integer givenID;
        String oldPassword, newPassword;
        int chances = 5;
        Scanner scanner = new Scanner(System.in);
        try {
            givenID = checkIfRegistryContainsId(registryList.getReaderRegistry());
            while (chances > 0) {
                System.out.println("Enter old Password");
                oldPassword = scanner.nextLine();
                if (oldPassword.equals(registryList.getReaderRegistry().getEntryById(givenID).getPassword())) break;
                else {
                    chances--;
                    System.out.println("Invalid answer. Available chances: " + chances);
                }
            }
            if (chances == 0) return;
            System.out.println("Enter new Password");
            newPassword = scanner.nextLine();

            registryList.getReaderRegistry().updateUserPassword(givenID, newPassword);
        } catch (Exception e) {
            System.out.println("Invalid input while updating password");
        }
    }

    private void updateDateOfReturn() {
        Integer givenId;
        Scanner scanner = new Scanner(System.in);
        String returnDate;
        Date dateOfReturn;
        try {
            givenId = checkIfRegistryContainsId(registryList.getRentalRegistry());
            System.out.println("Enter the return date in formatt yyyy-mm-dd or type keyword NOW ");
            returnDate = scanner.nextLine(); // todo() while loop until given valid date format
            if (returnDate.equals("NOW")) dateOfReturn = Utils.getDateNow();
            else dateOfReturn = Utils.parseDate(returnDate);
            registryList.getRentalRegistry().updateDateOfReturn(givenId, dateOfReturn);
        } catch (Exception e) {
            System.out.println("invalid input updating date of return");
        }

    }

    private void showReader() {
        Integer givenId;
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter Reader Id");
            givenId = checkIfRegistryContainsId(registryList.getReaderRegistry());
            System.out.println(registryList.getReaderRegistry().getEntryById(givenId));
        } catch (Exception e) {
            System.out.println("invalid input");
        }
    }

    private void showBookCopy() {
        Integer givenId;
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter Book copy Id");
            givenId = checkIfRegistryContainsId(registryList.getBookCopyRegistry());
            System.out.println(registryList.getBookCopyRegistry().getEntryById(givenId));
        } catch (Exception e) {
            System.out.println("invalid input");
        }
    }

    private void showRental() {
        Integer givenId;
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter rental Id");
            givenId = checkIfRegistryContainsId(registryList.getRentalRegistry());
            System.out.println(registryList.getRentalRegistry().getEntryById(givenId));
        } catch (Exception e) {
            System.out.println("invalid input");
        }
    }

    private void showPenalty() {
        Integer givenId;
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter rental Id");
            givenId = checkIfRegistryContainsId(registryList.getRentalRegistry());
            Rental rental = registryList.getRentalRegistry().getEntryById(givenId);
            rental.countPenalty(rental.getDateOfReturnOptional().get());
            System.out.println(rental.getPenaltyOptional().get());
        } catch (Exception e) {
            System.out.println("invalid input");
        }
    }

    private void deleteReader() {
        Integer givenId;
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter Reader Id");
            givenId = scanner.nextInt();
            registryList.getReaderRegistry().deleteEntryById(givenId);
            System.out.println("Successfully deleted user with id - " + givenId);
        } catch (Exception e) {
            System.out.println("invalid input");
        }
    }

    private void deleteBookCopy() {
        Integer givenId;
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter Book Id");
            givenId = scanner.nextInt();
            registryList.getBookCopyRegistry().deleteEntryById(givenId);
            System.out.println("Successfully deleted book copy with id - " + givenId);
        } catch (Exception e) {
            System.out.println("invalid input");
        }
    }

    private void saveRegistryList() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("registries.txt"); //todo() try catch
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(registryList);
        objectOutputStream.flush();
        objectOutputStream.close();
    }

    private Integer checkIfRegistryContainsId(Registry registry) {
        Integer givenID;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter id");
            givenID = scanner.nextInt();
            if (registry.checkIfcontainsID(givenID)) break;
            else System.out.println("registry doesn't contain id. Give a proper id"); // todo() daj możliwość na wyjście z pętli przez użycie słowa quit
        }

        return givenID;
    }

    private void showBookCopiesGivenStatus() {
        String rentalStatus;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter one of the following statuses: ");
            for (RentalStatus rentalStatus1 : RentalStatus.values()) {
                System.out.println(rentalStatus1.name());
            }
            rentalStatus = scanner.nextLine();
            if (checkIfStringInputEqualsRentalStatusValue(rentalStatus)) {
                break;
            } else System.out.println("give a valid status");
        }
        System.out.println(registryList.getBookCopyRegistry().getListOfCopiesGivenStatus(RentalStatus.valueOf(rentalStatus)));
    }

    private void showBookCopiesGivenCategory() {
        String bookCategory;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter one of the following categories: ");
            for (BookCategory bookCategory1 : BookCategory.values()) {
                System.out.println(bookCategory1.name());
            }
            bookCategory = scanner.nextLine();
            if (checkIfStringInputEqualsBookCategoryValue(bookCategory)) {
                break;
            } else System.out.println("give a valid book category");
        }
        System.out.println(registryList.getBookCopyRegistry().getListOfCopiesGivenCategory(BookCategory.valueOf(bookCategory)));
    }

    public void showReadersBooks() {
        List<Reader> listOfReaders = registryList.getReaderRegistry().getReaderList();
        List<Rental> listOfRentals = registryList.getRentalRegistry().getRentalList();
        List<BookCopy> listOfBooks = new LinkedList<>();
        for (Reader reader : listOfReaders) {
            {
                for (Rental rental : listOfRentals)
                    if (rental.getReader().equals(reader)) listOfBooks.add(rental.getBookCopy());
                System.out.println("Reader id: " + reader.getReaderId());
                System.out.println("Reader name and surname: " + reader.getName() + " " + reader.getSurname());
                System.out.println("Books rented: " + listOfBooks);
                listOfBooks.clear();
            }

        }
    }

    public void showReaderBooks() {
        List<Rental> listOfRentals = registryList.getRentalRegistry().getRentalList();
        List<BookCopy> listOfBooks = new LinkedList<>();

        Integer readerID;
        try {
            System.out.println("Enter Reader Id");
            readerID = checkIfRegistryContainsId(registryList.getReaderRegistry());
        } catch (Exception e) {
            System.out.println("invalid input");
            return;
        }

        Reader reader = registryList.getReaderRegistry().getEntryById(readerID);
        for (Rental rental : listOfRentals)
            if (rental.getReader().equals(reader)) listOfBooks.add(rental.getBookCopy());
        System.out.println("Reader id: " + reader.getReaderId());
        System.out.println("Reader name and surname: " + reader.getName() + " " + reader.getSurname());
        System.out.println("Books rented " + listOfBooks.size() + ": " + listOfBooks);
        listOfBooks.clear();

    }





}
