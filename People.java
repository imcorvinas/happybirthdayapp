import java.util.*;

public class People {
    private String name;
    private Set<Person> people;
    public People (String name) {
        this.name=name;
        this.people=new TreeSet<Person>();
    }
    public People (String name, Comparator comp) {
        this.name=name;
        this.people=new TreeSet<Person>(comp);
    }
    public boolean addPerson(Person person) {
        if (people.add(person)) return true;
        else return false;
    }
    public People sortCostAsc () {
        People group = new People(name, new CompDateAsc());
        for (Person person:people) group.addPerson(person);
        return group;
    }
}
