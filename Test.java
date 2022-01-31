import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Iterator;
import java.util.Scanner;

public class Test {
    public static void main (String[] args) {
        /*Person[] arr_person = new Person[6];
        LocalDate date = LocalDate.of(1996, 7, 28);
        arr_person[0] = new Person("Alexander", date);
        date = LocalDate.of(1987, 1,25);
        arr_person[1] = new Person("Maxim", date);
        date = LocalDate.of(1977, 10,16);
        arr_person[2] = new Person("Elizabeth", date);
        date = LocalDate.of(1997, 1,31);
        arr_person[3] = new Person("Katherine", date);
        date = LocalDate.of(1989, 7,7);
        arr_person[4] = new Person("Mark", date);
        date = LocalDate.of(1983, 6,28);
        arr_person[5] = new Person("Olivia", date);*/
        People people_all = new People("All people");
        People people_before = new People("People with birthdays passed");
        People people_today = new People("People with birthdays today");
        People people_after = new People("People with birthdays to come");
        ZoneId z = ZoneId.of("Europe/Moscow");
        LocalDate today = LocalDate.now( z );
        people_all.loadPeople();
        for (Person person : people_all.getPeople()) {
            if (person.compareWith(today) == -1) people_before.addPerson(person);
                else if (person.compareWith(today) == 0) people_today.addPerson(person);
                    else if (person.compareWith(today) == 1) people_after.addPerson(person);
        }
        people_today.putPeople();
        people_after.putPeople();
        Scanner scan = new Scanner(System.in);
        int scanned = 1;
        while (scanned != 0) {
            System.out.println("Type the number of needed action:\n" +
                    "1 - Load data\n" +
                    "2 - Save data\n" +
                    "3 - Put people with birthdays passed\n" +
                    "4 - Put people with birthdays today\n" +
                    "5 - Put people with birthdays to come\n" +
                    "0 - Exit program");
            scanned = scan.nextInt();
            switch (scanned) {
                case 1 -> people_all.loadPeople();
                case 2 -> {
                    people_before.savePeople();
                    people_today.savePeople();
                    people_after.savePeople();
                }
                case 3 -> people_before.putPeople();
                case 4 -> people_today.putPeople();
                case 5 -> people_after.putPeople();
            }
        }
    }
}
