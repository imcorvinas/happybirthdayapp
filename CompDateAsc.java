import java.time.MonthDay;
import java.util.*;

public class CompDateAsc implements Comparator {
    public int compare (Object obj1, Object obj2) {
        Person ps1 = (Person) obj1;
        Person ps2 = (Person) obj2;
        MonthDay birthMonthDay1 = MonthDay.from(ps1.getBirthday());
        MonthDay birthMonthDay2 = MonthDay.from(ps2.getBirthday());
        if (birthMonthDay1.isBefore(birthMonthDay2)) return -1;
        else if (birthMonthDay1.equals(birthMonthDay2)) return 0;
        else return 1;
    }
}