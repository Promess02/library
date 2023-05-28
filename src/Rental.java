import java.util.Date;
import java.util.Calendar;
import java.util.Optional;

public class Rental{
    private Integer rentalNumber;
    private Reader reader;
    private BookCopy bookCopy;
    private Date dateOfRental;

    private Optional<Date> dateOfReturn;
    private Optional<Float> penalty;
    public Rental(Integer rentalNumber, Reader reader, BookCopy bookCopy, Date dateOfRental, Optional<Date> dateOfReturn) {
        this.rentalNumber = rentalNumber;
        this.reader = reader;
        this.bookCopy = bookCopy;
        this.dateOfRental = dateOfRental;
        this.dateOfReturn = dateOfReturn;
        this.penalty = Optional.ofNullable(null);
    }
    public BookCopy getBookCopy() {
        return bookCopy;
    }
    public Integer getRentalNumber() {
        return rentalNumber;
    }

    public Reader getReader() {
        return reader;
    }

    public Optional<Float> getPenalty() {
        return penalty;
    }

    public Date getDateOfRental() {
        return dateOfRental;
    }

    public void setDateOfRental(Date dateOfRental) {
        this.dateOfRental = dateOfRental;
    }

    public Optional<Date> getDateOfReturn() {
        return dateOfReturn;
    }

    public void setDateOfReturn(Date dateOfReturn) {
        this.dateOfReturn = Optional.of(dateOfReturn);
    }


    public void countPenalty(){
        if(dateOfReturn.isEmpty()){
            System.out.println("Not able to count penalty, because the book hasn't been returned yet");
            return;
        }
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(dateOfRental);

        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(dateOfReturn.get());

        // Extract year and month values
        int year1 = calendar1.get(Calendar.YEAR);
        int month1 = calendar1.get(Calendar.MONTH);

        int year2 = calendar2.get(Calendar.YEAR);
        int month2 = calendar2.get(Calendar.MONTH);

        // Calculate the difference in months
        int monthsDiff = (year2 - year1) * 12 + (month2 - month1);

        // Adjust the difference based on the day values if necessary
        int day1 = calendar1.get(Calendar.DAY_OF_MONTH);
        int day2 = calendar2.get(Calendar.DAY_OF_MONTH);

        if (day2 < day1) {
            monthsDiff--;
        }

        if(monthsDiff>0) penalty = Optional.of(monthsDiff*Utils.penaltyForMonth);
        else penalty = Optional.empty();
    }

    @Override
    public String toString() {
        String dateOfReturntoString;
        String penaltyToString;
        if(dateOfReturn.isEmpty()) dateOfReturntoString = "null";
        else dateOfReturntoString = dateOfReturn.toString();
        if(penalty.isEmpty()) penaltyToString = "null";
        else penaltyToString = penalty.toString();
        return "Rental{" +
                "rentalNumber=" + rentalNumber +
                ", reader=" + reader +
                ", bookCopy=" + bookCopy +
                ", dateOfRental=" + dateOfRental +
                ", dateOfReturn=" + dateOfReturntoString +
                ", penalty=" + penaltyToString +
                '}';
    }
}
