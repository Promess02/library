import java.io.Serializable;
import java.util.Date;
import java.util.Calendar;
import java.util.Optional;

/**
 * Class for rentals, which implements the serializable interface
 */
public class Rental implements Serializable {
    final private Integer rentalNumber;
    final private Reader reader;
    final private BookCopy bookCopy;
    final private Date dateOfRental;
    final private Integer timeOfRental;
    /**
     * Serializable optional of java.util.Date. When object created it is set to empty Optional
     * It can be set by setDateOfReturn() method
     */
    private SerializableOptional<Date> dateOfReturn;
    /**
     * Serializable optional of Float. When object created it is set to empty Optional
     * It can be set by countPenalty(date) method based on the difference between date of rental and date of return
     */
    private SerializableOptional<Float> penalty;

    /**
     * Sets date of return and optional objects to empty optionals
     * @param rentalNumber id of the rental
     * @param reader reader in the rental
     * @param bookCopy book copy in the rental
     * @param timeOfRental time for rental, after which penalty will be counted based on date of return
     * @param dateOfRental date in which the rental happened
     * @see Reader
     * @see BookCopy
     */
    public Rental(Integer rentalNumber, Reader reader, BookCopy bookCopy, Integer timeOfRental, Date dateOfRental) {
        this.rentalNumber = rentalNumber;
        this.reader = reader;
        this.bookCopy = bookCopy;
        this.dateOfRental = dateOfRental;
        this.timeOfRental = timeOfRental;
        this.dateOfReturn = new SerializableOptional<>(Optional.empty());
        this.penalty = new SerializableOptional<>(Optional.empty());
    }

    /**
     * Returns object of class BookCopy.
     * @return BookCopy
     * @see BookCopy
     */
    public BookCopy getBookCopy() {
        return bookCopy;
    }

    /**
     * Returns time of rental
     * @return Integer
     */
    public Integer getTimeOfRental() {
        return timeOfRental;
    }

    /**
     * Returns rental number (rental id)
     * @return Integer
     */
    public Integer getRentalNumber() {
        return rentalNumber;
    }

    /**
     * Returns reader object
     * @return Integer
     * @see Reader
     */
    public Reader getReader() {
        return reader;
    }

    /**
     * returns SerializableOptional of Float object being the penalty for rental
     * @return SerializableOptional penalty for overdue rental
     * @see SerializableOptional
     */
    public SerializableOptional<Float> getPenaltyOptional() {
        return penalty;
    }

    /**
     * Returns java.util.Date object of Date in which the rental happened
     * @return Returns Date object in which the rental happened
     */
    public Date getDateOfRental() {
        return dateOfRental;
    }

    /**
     * Returns SerializableOptional object of java.util.Date object being the date of Return
     * @return SerializableOptional of return date of the book
     * @see SerializableOptional
     */
    public SerializableOptional<Date> getDateOfReturnOptional() {
        return dateOfReturn;
    }

    /**
     * sets the date of return
     * @param dateOfReturn Date object. Date in which return of the book happened
     */
    public void setDateOfReturn(Date dateOfReturn) {
        this.dateOfReturn.set(dateOfReturn);
    }


    /**
     * sets the penalty inside our Rental object
     * counts it based on the difference in months between dateOfRental and dateOfReturn. Amount per month is set in Utils.penaltyForMonth
     * @param date - if dateOfReturn inside the object is null then the function counts penalty based on this parameter
     */
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
        else penalty = new SerializableOptional<>(Optional.empty());
    }

    /**
     * @return String - returns a string containing information about rental
     */
    @Override
    public String toString() {
        String dateOfReturntoString;
        String penaltyToString;
        if(dateOfReturn.toOptional().isEmpty()) dateOfReturntoString = "null";
        else dateOfReturntoString = dateOfReturn.toString();
        if(penalty.toOptional().isEmpty()) penaltyToString = "null";
        else penaltyToString = penalty.toString();
        return "Rental:" +
                "rentalNumber=" + rentalNumber +
                "\nreader=" + reader +
                "\nbookCopy=" + bookCopy +
                "\ndateOfRental=" + dateOfRental +
                "\n dateOfReturn=" + dateOfReturntoString +
                "\n penalty=" + penaltyToString +
                '\n';
    }
}
