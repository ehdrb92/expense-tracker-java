import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CommonUtil {
    public LocalDate convertStringToLocalDate(String string) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(string, formatter);
        return date;
    }
}
