package dietApp.dietapp.config;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CurrentDateAsString {

    private static LocalDateTime now = LocalDateTime.now();
    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static String getTodayDate(){
        return dateTimeFormatter.format(now);
    }
}
