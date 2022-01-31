import java.io.*;
import java.time.LocalDate;
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
    public String getName() {
        return this.name;
    }

    public Set<Person> getPeople() {
        return people;
    }

    public void setName(String name) {
        this.name = name;
    }
    public boolean addPerson(Person person) {
        return people.add(person);
    }
    public People sortCostAsc () {
        People group = new People(name, new CompDateAsc());
        for (Person person:people) group.addPerson(person);
        return group;
    }
    public void putPeople () {
        System.out.println(name);
        for (Person person: people) {
            System.out.printf("%-10s, %-10s\n", person.getName(), person.getBirthday().toString());
        }
    }
    public void loadPeople () {
        people.removeAll(people);
        String line;
        BufferedReader inp;
        String[] data;
        try{
            inp = new BufferedReader(new FileReader("input_data.txt"));
            while ((line = inp.readLine()) != null){
                line = line.trim();
                if(line.equals("")) continue;
                data = line.split(",");
                data[1] = data[1].substring(1);
                people.add(new Person(data[0], LocalDate.parse(data[1])));
            }
        } catch (Exception e){
            System.out.println("Error - " + e.getMessage());
        }
    }
    public void savePeople () {
        PrintWriter out = null;
        try{
            out = new PrintWriter(new FileWriter("output_data.txt", true));
            for (Person guys:people) {
                StringBuilder line = new StringBuilder();
                line.append(String.format("%s, %s",guys.getName(), guys.getBirthday()));
                out.println(line);
            }
        }
        catch (IOException e) {
            System.out.println(e);
        }
        finally {
            if(out != null) out.close();
        }
    }
}
