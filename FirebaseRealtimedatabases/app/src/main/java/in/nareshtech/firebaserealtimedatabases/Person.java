package in.nareshtech.firebaserealtimedatabases;

public class Person {

    String person_name;
    int person_age;

    public Person() {
        // We need an Empty Constructor
    }

    public Person(String person_name, int person_age) {
        this.person_name = person_name;
        this.person_age = person_age;
    }

    public String getPerson_name() {
        return person_name;
    }

    public int getPerson_age() {
        return person_age;
    }
}
