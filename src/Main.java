import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        List<Person> people = getPeople();

        // FILTER
        List<Person> femaleList = people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .collect(Collectors.toList());

        System.out.println("FITERED BY FEAMALE GENDER-> LIST OF FEMALES :: ");

        femaleList.forEach(System.out::println);

        //SORT
        // ASCENDING
        List<Person> ascendingOrderList = people.stream()
                .sorted(Comparator.comparing(Person::getAge).thenComparing(Person::getGender))
                .collect(Collectors.toList());

        System.out.println("\n\n\nSORTING");
        System.out.println("ASCENDING ORDER BY AGE THEN GENDER :: ");

        ascendingOrderList.forEach(System.out::println);

        // DECENDING
        List<Person> descendingOrderList = people.stream()
                .sorted(Comparator.comparing(Person::getAge).thenComparing(Person::getGender).reversed())
                .collect(Collectors.toList());

        System.out.println("\n\n\nDECENDING ORDER BY AGE THEN GENDER :: ");

        descendingOrderList.forEach(System.out::println);

        // ALL MATCH
        boolean allMatch = people.stream()
                .allMatch(person -> person.getAge() > 5);

        System.out.println("\n\n\nALL MATCH:: " + allMatch);

        allMatch = people.stream()
                .allMatch(person -> person.getAge() > 33);

        System.out.println("\nALL MATCH:: " + allMatch);

        boolean anyMatch = people.stream()
                .anyMatch(person -> person.getAge() > 150);

        // ANY MATCH
        System.out.println("\n\n\nANY MATCH :: " + anyMatch);

        anyMatch = people.stream()
                .anyMatch(person -> person.getAge() < 50);

        System.out.println("\nANY MATCH :: " + anyMatch);

        boolean noneMatch = people.stream()
                .noneMatch(person -> person.getName().equalsIgnoreCase("Alex"));

        // NONE MATCH
        System.out.println("\n\n\nNONE MATCH :: " + noneMatch);

        noneMatch = people.stream()
                .noneMatch(person -> person.getName().equalsIgnoreCase("Alex Boz"));

        System.out.println("\nNONE MATCH :: " + noneMatch);

        noneMatch = people.stream()
                .noneMatch(person -> person.getName().equalsIgnoreCase("ROY"));

        System.out.println("\nNONE MATCH :: " + noneMatch);


        // MAX
        System.out.println("\n\n\nMAX:: ");

        people.stream()
                .max(Comparator.comparing(person -> person.getAge()))
                .ifPresent(System.out::println);

        // MIN
        System.out.println("\n\n\nMIN:: ");

        people.stream()
                .min(Comparator.comparing(person -> person.getAge()))
                .ifPresent(System.out::println);

        // GROUP
        System.out.println("\n\n\nGROUP:: ");
        Map<Gender, List<Person>> groupByGender = people.stream()
                .collect(Collectors.groupingBy(Person::getGender));

        groupByGender.forEach((gender, people1) -> {
            System.out.println(gender);
            people1.forEach(System.out::println);
            System.out.println();
        });

        Optional<String> oldestFemaleAge = people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .max(Comparator.comparing(Person::getAge))
                .map(Person::getName);

        oldestFemaleAge.ifPresent(System.out::println);


    }

    private static List<Person> getPeople() {
        return  Arrays.asList(
                new Person("Antonio", 20, Gender.MALE),
                new Person("Alina Smith", 33, Gender.FEMALE),
                new Person("Alina Smith", 33, Gender.MALE),
                new Person("Helen White", 57, Gender.FEMALE),
                new Person("Alex Boz", 14, Gender.MALE),
                new Person("Jamie Goa", 99, Gender.MALE),
                new Person("Anna Cook", 7, Gender.FEMALE),
                new Person("Zelda Brown", 120, Gender.FEMALE)
        );
    }

}