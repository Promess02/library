import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Utils implements Serializable {
    static final Float penaltyForMonth = 3.14f;
    static final Date getDateNow(){
        ZoneId defaultZoneId = ZoneId.systemDefault();
        LocalDate localDate = LocalDate.now();
       return java.sql.Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
    }
    static final Date parseDate(String date) throws ParseException {
        return  new SimpleDateFormat("yyyy-MM-dd").parse(date);
    }
}
