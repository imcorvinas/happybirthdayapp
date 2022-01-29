import java.util.Date;
import java.time.*;

public class Person {
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
        return birthday;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}

