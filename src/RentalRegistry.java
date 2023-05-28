import java.sql.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class RentalRegistry {
    private List<Rental> rentalList;

    public RentalRegistry() {
        rentalList = new LinkedList<>();
    }
    public Integer getNumberOfRentals(){
        return rentalList.size();
    }
    public Integer getNumberOfCurrentRentals(){
        int sum = 0;
        for(Rental rental: rentalList){
            if(rental.getDateOfReturn().isEmpty()) sum++;
        }
        return sum;
    }

    public Rental addRental(Integer rentalNumber, Reader reader, BookCopy bookCopy, Date dateOfRental, Optional<Date> dateOfReturn){
        Rental rental = new Rental(rentalNumber,reader,bookCopy,dateOfRental,dateOfReturn);
        rentalList.add(rental);
        return rental;
    }

    public Integer getNumberOfOverdueRentals(){
        int sum = 0;
        for(Rental rental: rentalList){
            rental.countPenalty();
            if(rental.getPenalty().isPresent()) sum++;
        }
        return sum;
    }

}
