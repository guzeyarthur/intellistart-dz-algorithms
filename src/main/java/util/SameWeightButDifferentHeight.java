package util;
import models.Person;

public class SameWeightButDifferentHeight {// відповідь на завдання "Оцініть складність алгоритму по часу"
    public static int getCount(Person[] people) {// можна побачити у коментарях до коду
        int result = 0;
        int length = people.length;
        boolean flag = false;
        for (int i = 0; i < length; i++) { // N
            int count = 1;
            for (int j = i+1; j < length; j++) { // ( (1 + (N-1) ) * (N-1) )/2 - сума аріфметічної прогресиї до N-1
                if (people[i].getWeight() == people[j].getWeight() && people[i].getHeight() != people[j].getHeight()) {
                    flag = true;
                    count++;
                    Person temp = people[i+1];
                    people[i+1] = people[j];
                    people[j] = temp;
                    i++;
                }
            }
            if (flag) {
                result+=count;
                flag=false;
            }
        }
        return result;
    }//у результаті скорочень ми отрмаемо О (N^2)
}
