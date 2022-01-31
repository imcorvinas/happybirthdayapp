import java.time.LocalDate;
import java.time.MonthDay;

public class Person implements Comparable <Person>{
    private final static String PERSON_FORMAT_STRING = "%s, %s";
    private String name;
    private LocalDate birthday;
    public Person (String name, LocalDate birthday) {
        this.name = name;
        this.birthday = birthday;
    }
    public Person (Person obj) {
        this.name = obj.getName();
        this.birthday = obj.getBirthday();
    }
    public String getName() {
        return this.name;
    }
    public LocalDate getBirthday() {
        return this.birthday;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
    public int compareTo (Person person) {
        MonthDay birthMonthDateThis = MonthDay.from(this.birthday);
        MonthDay birthMonthDayToday = MonthDay.from(person.birthday);
        if (birthMonthDateThis.isBefore(birthMonthDayToday)) return -1;
        else if (birthMonthDateThis.equals(birthMonthDayToday)) return 0;
        else return 1;
    }
    public int compareWith (LocalDate today) {
        MonthDay birthMonthDateThis = MonthDay.from(this.birthday);
        MonthDay birthMonthDayToday = MonthDay.from(today);
        if (birthMonthDateThis.isBefore(birthMonthDayToday)) return -1;
        else if (birthMonthDateThis.equals(birthMonthDayToday)) return 0;
        else return 1;
    }
    public String toString() {return String.format(PERSON_FORMAT_STRING,name,birthday);}
}
