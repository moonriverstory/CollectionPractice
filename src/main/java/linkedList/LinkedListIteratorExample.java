package linkedList;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListIteratorExample {

    public static void main(String[] args) {
        LinkedList<Integer> values = new LinkedList<>();
        values.add(23);
        values.add(3);
        values.add(17);
        values.add(9);
        values.add(42);
        System.out.println("LinkedList ==> " + values);
        System.out.println("listIterator~~");
        Iterator<Integer> iter = values.listIterator();
        while (iter.hasNext()) {
            Integer ele = iter.next();
            System.out.println(ele);
        }
        System.out.println("listIterator with index~~");
        Iterator<Integer> iterWithIndex = values.listIterator(2);
        while (iterWithIndex.hasNext()) {
            Integer ele = iterWithIndex.next();
            System.out.println(ele);
        }
    }
}

