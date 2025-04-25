package co.edu.sena.stockclem.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

/**
 *
 * @author Esteban Colorado Vargas
 */
public class ConvertUtils {

    /**
     * convierte fecha a hora
     *
     * @param date
     * @return
     */
    public static String dateToString(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String result = dateFormat.format(date);
        return result;
    }

    /**
     * convierte un string en hora
     *
     * @param text
     * @return
     * @throws ParseException
     */
    public static Date stringToDate(String text) throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(text);
        return date;
    }

    /**
     * convierte una hora en String
     *
     * @param date
     * @return
     */
    public static String timeToString(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        String result = dateFormat.format(date);
        return result;
    }
    
    /**
     * convierte un string a una fecha
     * @param text
     * @return
     * @throws ParseException 
     */
    public static Date stringToTime(String text) throws ParseException{
        Date date = new SimpleDateFormat("HH:mm").parse(text);
        return date;
    }
    
    /**
     * convierte fecha local a fecha
     * @param localDate
     * @return 
     */
    public static Date localDateToDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
    
    /**
     * convierte hora local a fecha
     * @param localTime
     * @return 
     */
    public static Date localTimetoDate(LocalTime localTime) {
        return Date.from(LocalDate.now().atTime(localTime).atZone(ZoneId.systemDefault()).toInstant());
    }
    
    /**
     * convierte de date a localdate
     * @param date
     * @return 
     */
    public static LocalDate dateToLocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
}
