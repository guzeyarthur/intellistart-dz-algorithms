package sort;
import models.Person;
import java.util.Comparator;

public class PersonHeapSort {
    public static Person[] sortByAge(Person[] people) {
        return sort(people, Comparator.comparingInt(Person::getAge));
    }

    public static Person[] sortByWeight(Person[] people) {
        return sort(people, Comparator.comparingInt(Person::getWeight));
    }

    public static Person[] sortByHeight(Person[] people) {
        return sort(people, Comparator.comparingInt(Person::getHeight));
    }

    public static Person[] sort(Person[] people, Comparator<Person> personComparator) {
        int n = people.length;
        for (int i = n/2-1; i >= 0; i--) {
            heapify(people, i, n, personComparator);
        }
        for (int i = n-1; i >= 0; i--) {
            Person temp = people[i];
            people[i] = people[0];
            people[0] = temp;
            heapify(people, 0, i, personComparator);
        }
        return people;
    }

    private static void heapify(Person[] people, int i, int n, Comparator<Person> personComparator) {
        int leftNode = i * 2 + 1;
        int rightNode = i * 2 + 2;
        int largest = i;
        if (leftNode < n && personComparator.compare(people[leftNode], people[largest])>0) {
            largest = leftNode;
        }
        if (rightNode < n && personComparator.compare(people[rightNode], people[largest])>0) {
            largest = rightNode;
        }
        if (i != largest) {
            Person temp = people[i];
            people[i] = people[largest];
            people[largest] = temp;
            heapify(people, largest, n, personComparator);
        }
    }
}
