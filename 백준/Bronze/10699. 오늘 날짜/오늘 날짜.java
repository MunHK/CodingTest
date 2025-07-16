import java.time.*;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) throws Exception {
        LocalDate now = LocalDate.now();

        DateTimeFormatter fm = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String result=now.format(fm);

        System.out.println(result);
    }
}