package lessons;

public class lesson5HomeWork {
    public static void main(String[] args) {
        Person[] persArray = new Person[5];
        persArray[0] = new Person("Donatello", "Techie", "donatello@sewers.com", "555-000", 3, 41);
        persArray[1] = new Person("Raphael", "Renegade", "raphael@sewers.com", "555-001", 5, 36);
        persArray[2] = new Person("Michelangelo", "Comic relief", "michelangelo@sewers.com", "555-002", 2, 38);
        persArray[3] = new Person("Leonardo", "Leader", "leonardo@sewers.com", "555-003", 7, 45);
        persArray[4] = new Person("Splinter", "Teacher", "splinter@sewers.com", "555-099", 10, 415);

        for (Person person : persArray) {
            if (person.getAge() > 40) {
                person.printPersonalInfo();
            }
        }
    }
}
