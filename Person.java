import java.sql.Date;
import java.util.Objects;

public class Person implements Comparable <Person>{
    private String name;
    private Date birthday;
    public String getName() {
        return this.name;
    }
    public Date getBirthday() {
        return birthday;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return name.equals(person.name) && birthday.equals(person.birthday);
    }
    public int compareTo (Person person) {
        if () return -1;
        if ((this.name.equals(person.getName()))&&(this.birthday.equals(person.getBirthday()))) return 0;
        else return 1;
    }
}

