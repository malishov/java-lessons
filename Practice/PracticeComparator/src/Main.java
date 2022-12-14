import Comparators.PersonNameComparator;
import Model.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> humans= new ArrayList<>();
        Person person1 = new Person("Murad");
        Person person2 = new Person("Anna");
        Person person3 = new Person("Zal");

        humans.add(person1);
        humans.add(person2);
        humans.add(person3);

//        PersonNameComparator comparator = new PersonNameComparator();


        System.out.println(humans.);

        Collections.sort(humans, new PersonNameComparator());


        System.out.println(humans.toArray());

    }
}