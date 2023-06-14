import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * Class containing utility methods and variables
 */
public class Utils implements Serializable {
    /**
     * value of penalty for each month of rental overdue
     */
    static final Float penaltyForMonth = 3.14f;

    /**
     * returns the current system date as java.util.Date object
     * @return Date
     */
    static final Date getDateNow(){
        ZoneId defaultZoneId = ZoneId.systemDefault();
        LocalDate localDate = LocalDate.now();
       return java.sql.Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
    }

    /**
     * parses Date from String of format "yyyy-mm-dd". Catches Parse Exception
     * @param date - String of date
     * @return java.util.Date
     */
    static final Date parseDate(String date){
        try{
            return  new SimpleDateFormat("yyyy-MM-dd").parse(date);
        }
        catch(ParseException e){
            e.printStackTrace();
            return null;
        }

    }
}
