package test;

import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class Test {
    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> numbers = new CopyOnWriteArrayList<>();
        Collections.addAll(numbers, new Integer[]{1,2,3,4,5});

        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            Integer number = iterator.next();
            numbers.add(6);
            System.out.println(number);
        }
    }
    
}