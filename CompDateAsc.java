import java.util.*;

public class CompDateAsc implements Comparator {
    public int compare (Object obj1, Object obj2) {
        Person ps1 = (Person) obj1;
        Person ps2 = (Person) obj2;
        if (ps1.getBirthday().isBefore(ps2.getBirthday())) return -1;
        else if (ps1.getBirthday().isEqual(ps2.getBirthday())) return 0;
        else return 1;
    }
}