package Task_43;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Main {

    // Если вдруг неправильно понял задачу
    public ArrayList<Human> sort(ArrayList<Human> humans){
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 1; i < humans.size(); i++) {
                Human rightHuman = humans.get(i);
                Human leftHuman = humans.get(i - 1);
                if (Human.oldCompareTo(rightHuman.getFullName(), leftHuman.getFullName())<0) {
                    Collections.swap(humans, i, i-1);
                    isSorted = false;
                }
            }
        }
        return humans;
    }

    public static void main(String[] args) {
        LinkedList<Human> humans = new LinkedList<>();
        Human firstHuman = new Human("Михаил", "Андрейцев", "Игоревич");
        Human secondHuman = new Human("Даниил", "Михеев", "Евгеньевич");
        Human thirdHuman = new Human("Иван", "Лобанов", "Александрович");
        humans.add(firstHuman);
        humans.add(secondHuman);
        humans.add(thirdHuman);

        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 1; i < humans.size(); i++) {
                Human rightHuman = humans.get(i);
                Human leftHuman = humans.get(i - 1);
                if ((rightHuman.compareTo(leftHuman))<0) {
                    Collections.swap(humans, i, i-1);
                    isSorted = false;
                }
            }
        }
        System.out.println(humans);
    }
}
