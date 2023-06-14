import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Class that implements Registry and serializable interfaces and stores information about rentals
 * @see Registry
 * @see Serializable
 */
public class RentalRegistry implements Registry, Serializable {
    @Serial
    private static final long serialVersionUID = 3L;
    private List<Rental> rentalList;

    /**
     * Default Constructor used to initiate the rental list with an instance of empty Linked list
     */
    public RentalRegistry() {
        rentalList = new LinkedList<>();
    }

    /**
     * returns the size of rental list
     * @return number of rentals
     */
    public Integer getNumberOfRentals(){
        return rentalList.size();
    }

    /**
     * returns the number of rentals in which the date of return is empty
     * @return number of current rentals
     */
    public Integer getNumberOfCurrentRentals(){
        int sum = 0;
        for(Rental rental: rentalList){
            if(rental.getDateOfReturnOptional().toOptional().isEmpty()) sum++;
        }
        return sum;
    }

    /**
     * adds a new rental to the registry
     * @param reader - instance of Reader
     * @param bookCopy - instance of book copy
     * @param dateOfRental - date in which the book was rented
     * @param timeOfRental - time in months for which the book is rented penalty-free
     * @return Rental object
     * @see Rental
     * @see Reader
     * @see BookCopy
     */
    public Rental addRental(Reader reader, BookCopy bookCopy, Date dateOfRental, Integer timeOfRental){
        Rental rental = new Rental(rentalList.size()+1,reader,bookCopy,timeOfRental, dateOfRental);
        if(rental.getBookCopy().getRentalStatus().equals(RentalStatus.RENTED)) {
            System.out.println("Book copy not available");
            return null;
        }
        bookCopy.setRentalStatus(RentalStatus.RENTED);
        rentalList.add(rental);
        return rental;
    }

    /**
     * updates the date in which the book is returned. Simulates the book being returned
     * @param rentalNumber - id number of rental
     * @param date - date of return
     */
    public void updateDateOfReturn(Integer rentalNumber, Date date){
        rentalList.stream()
                .filter(rental -> rental.getRentalNumber().equals(rentalNumber))
                .findFirst()
                .ifPresent(rental -> {
                    rental.setDateOfReturn(date);
                    rental.getBookCopy().setRentalStatus(RentalStatus.AVAILABLE);
                    rental.countPenalty(date);
                });

    }

    /**
     * Returns a list of rentals in which the difference in months between date of rental and date of return is greater than time of rental
     * @return list of overdue rentals
     */
    public LinkedList<Rental> getListOfOverdueRentals(){
        LinkedList<Rental> overdueRentals = new LinkedList<>();
        for(Rental rental: rentalList){
            rental.countPenalty(rental.getDateOfReturnOptional().get());
            if(rental.getPenaltyOptional().toOptional().isPresent()) overdueRentals.add(rental);
        }
        return overdueRentals;
    }

    /**
     * returns the list of rentals in the registry
     * @return list of rentals in the registry
     * @see Rental
     */
    public List<Rental> getRentalList(){
        return rentalList;
    }

    /**
     * Returns a string of information about rentals in the rental registry.
     * @return String
     */
    @Override
    public String toString() {
        return "RentalRegistry{" +
                "rentalList=" + rentalList +
                '}';
    }

    /**
     * Overriden method from Registry interface that returns a Rental object when provided its rental number(id)
     * @param id - rental number
     * @return Rental
     * @see Rental
     */
    @Override
    public Rental getEntryById(Integer id) {
        for(Rental rental: rentalList){
        if(rental.getRentalNumber().equals(id)) return rental;
    }
        return null;
    }

    /**
     * if given id found: deletes the rental with that id else does nothing
     * @param id - rental number
     */
    @Override
    public void deleteEntryById(Integer id) {
        rentalList.stream()
                .filter( reader -> reader.getRentalNumber().equals(id))
                .findFirst()
                .ifPresent(reader -> rentalList.remove(reader));
    }

    /**
     * @param id - rental number
     * @return boolean
     */
    @Override
    public boolean checkIfcontainsID(Integer id) {
        for(Rental rental: rentalList){
            if(rental.getRentalNumber().equals(id)) return true;
        }
        return false;
    }
}
