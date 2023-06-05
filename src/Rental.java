import java.io.Serializable;
import java.util.Date;
import java.util.Calendar;
import java.util.Optional;

public class Rental implements Serializable {
    final private Integer rentalNumber;
    final private Reader reader;
    final private BookCopy bookCopy;
    final private Date dateOfRental;
    final private Integer timeOfRental;
    private SerializableOptional<Date> dateOfReturn;
    private SerializableOptional<Float> penalty;
    public Rental(Integer rentalNumber, Reader reader, BookCopy bookCopy, Integer timeOfRental, Date dateOfRental) {
        this.rentalNumber = rentalNumber;
        this.reader = reader;
        this.bookCopy = bookCopy;
        this.dateOfRental = dateOfRental;
        this.timeOfRental = timeOfRental;
        this.dateOfReturn = new SerializableOptional<>(Optional.empty());
        this.penalty = new SerializableOptional<>(Optional.empty());
    }
    public BookCopy getBookCopy() {
        return bookCopy;
    }

    public Integer getTimeOfRental() {
        return timeOfRental;
    }

    public Integer getRentalNumber() {
        return rentalNumber;
    }

    public Reader getReader() {
        return reader;
    }

    public SerializableOptional<Float> getPenalty() {
        return penalty;
    }

    public Date getDateOfRental() {
        return dateOfRental;
    }

    public SerializableOptional<Date> getDateOfReturn() {
        return dateOfReturn;
    }

    public void setDateOfReturn(Date dateOfReturn) {
        this.getDateOfReturn().set(dateOfReturn);
    }


    public void countPenalty(Date date){
        Date finalDate;
        if(dateOfReturn.toOptional().isEmpty()) finalDate = date;
        else finalDate = dateOfReturn.get();

        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(dateOfRental);

        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(finalDate);

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

        if(monthsDiff>timeOfRental) penalty.set((monthsDiff-timeOfRental)*Utils.penaltyForMonth);
        else penalty.set(null);
    }

    @Override
    public String toString() {
        String dateOfReturntoString;
        String penaltyToString;
        if(dateOfReturn.toOptional().isEmpty()) dateOfReturntoString = "null";
        else dateOfReturntoString = dateOfReturn.toString();
        if(penalty.toOptional().isEmpty()) penaltyToString = "null";
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
