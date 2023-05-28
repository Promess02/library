import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public Rental addRental(Reader reader, BookCopy bookCopy, Date dateOfRental, Optional<Date> dateOfReturn){
        Rental rental = new Rental(rentalList.size()+1,reader,bookCopy,dateOfRental,dateOfReturn);
        rentalList.add(rental);
        return rental;
    }

    public void updateDateOfReturn(Integer rentalNumber, Date date){
        rentalList.stream()
                .filter(rental -> rental.getRentalNumber().equals(rentalNumber) || rental.getDateOfReturn().isEmpty())
                .findFirst()
                .ifPresent(rental -> rental.setDateOfReturn(date));
    }


    public Integer getNumberOfOverdueRentals(){
        int sum = 0;
        for(Rental rental: rentalList){
            rental.countPenalty();
            if(rental.getPenalty().isPresent()) sum++;
        }
        return sum;
    }

    public List<Rental> getRentalList(){
        return rentalList;
    }

    public Rental getRentalById(Integer rentalId){
        for(Rental rental: rentalList){
            if(rental.getRentalNumber().equals(rentalId)) return rental;
        }
        return null;
    }

    @Override
    public String toString() {
        return "RentalRegistry{" +
                "rentalList=" + rentalList +
                '}';
    }
}
