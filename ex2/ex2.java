package ex2;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ex2 {
    public static void main(String[] args) {
        // Create a list of Human objects
        List<Human> humans = new ArrayList<>();
        humans.add(new Human(25, "Alice", "Smith", LocalDate.of(1996, 5, 12), 60));
        humans.add(new Human(30, "Bob", "Johnson", LocalDate.of(1991, 8, 2), 75));
        humans.add(new Human(40, "Charlie", "Brown", LocalDate.of(1981, 3, 21), 80));

        // Perform an action on each object in the list
//        for (Human human : humans) {
//            System.out.println(human.getFirstName() + " " + human.getLastName() + " is " + human.getAge() + " years old and weighs " + human.getWeight() + "kg.");
//        }
        //Sort by date of birth, filter by age less than 50, sort by weight, concatenate all names in one big string, separated by space using the Stream
        String result = humans.stream()
                .filter(p -> p.getAge() < 50)
                .sorted((p1, p2) -> Integer.compare(p1.getWeight(), p2.getWeight()))
                .sorted((p1, p2) -> p1.getBirthDate().compareTo(p2.getBirthDate()))
                .map(Human::getFirstName)
                .collect(Collectors.joining(" "));
        System.out.println(result);
    }
}
class Human{
    private int age;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private int weight;

    public Human(int age, String firstName, String lastName, LocalDate birthDate, int weight) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.weight = weight;
    }

    // Getters and setters
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}