import models.Person;
import sort.PersonHeapSort;
import util.SameWeightButDifferentHeight;

public class StartApp {
    public static void main(String[] args) {
        Person[] people = {
            new Person(190, 86, 18),
            new Person(180, 80, 55),
            new Person(175, 55, 23),//1
            new Person(155, 55, 33),//1
            new Person(160, 60, 65),
            new Person(160, 55, 65),//1
            new Person(160, 55, 35),//--
            new Person(155, 65, 12),
            new Person(145, 55, 13),//1
            new Person(110, 73, 65),//2
            new Person(148, 40, 5),//3
            new Person(163, 124, 80),
            new Person(153, 40, 22),//3
            new Person(164, 77, 43),
            new Person(110, 73, 10),//--
            new Person(180, 91, 36),
            new Person(116, 73, 13),//2
            new Person(150, 40, 58),//3
        };

        PersonHeapSort.sortByAge(people);
        System.out.println("Sort by age");
        printPeople(people);

        PersonHeapSort.sortByWeight(people);
        System.out.println("Sort by weight");
        printPeople(people);

        PersonHeapSort.sortByHeight(people);
        System.out.println("Sort by height");
        printPeople(people);

        System.out.println("Count of people with same weight but different height "
                + SameWeightButDifferentHeight.getCount(people));
    }

    private static void printPeople(Person[] people) {
        for (Person item : people) {
            System.out.println(item);
        }
    }
}
