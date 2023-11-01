import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TaskDate {

    public static void main(String[] args) {
        String date1 = "1-12-2023";
        String date2 = "12/01/2023";

        LocalDate local1 = LocalDate.parse(date1, DateTimeFormatter.ofPattern("d-MM-yyyy"));
        System.out.println(local1);
        LocalDate local2 = LocalDate.parse(date2, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        System.out.println(local2);
        System.out.println(local1.equals(local2));

        LocalDate dateNow = LocalDate.now();
        System.out.println(dateNow);

        System.out.println(local1.isBefore(dateNow));
    }
}
