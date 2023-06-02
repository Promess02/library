import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RentalRegistry implements Registry{
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

    public LinkedList<Rental> getListOfOverdueRentals(){
        LinkedList<Rental> overdueRentals = new LinkedList<>();
        ZoneId defaultZoneId = ZoneId.systemDefault();
        LocalDate localDate = LocalDate.now();
        Date dateNow = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
        for(Rental rental: rentalList){
            rental.countPenalty(dateNow);
            if(rental.getPenalty().isPresent()) overdueRentals.add(rental);
        }
        return overdueRentals;
    }

    public List<Rental> getRentalList(){
        return rentalList;
    }

    @Override
    public String toString() {
        return "RentalRegistry{" +
                "rentalList=" + rentalList +
                '}';
    }

    @Override
    public Rental getEntryById(Integer id) {
        for(Rental rental: rentalList){
        if(rental.getRentalNumber().equals(id)) return rental;
    }
        return null;
    }

    @Override
    public void deleteEntryById(Integer id) {
        rentalList.stream()
                .filter( reader -> reader.getRentalNumber().equals(id))
                .findFirst()
                .ifPresent(reader -> rentalList.remove(reader));
    }
}
