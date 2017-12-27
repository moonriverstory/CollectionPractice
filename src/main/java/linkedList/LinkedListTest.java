package linkedList;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList lList = new LinkedList();
        lList.add("25");
        lList.add("18");
        lList.add("77");
        lList.add("KB");
        lList.add("56");
        System.out.println(lList.toString());
        System.out.println(lList.getFirst());
        System.out.println(lList.getLast());

        lList.addAll(Arrays.asList(new String[]{"1","2"}));

        lList.add(3,"81");
        lList.addFirst("ff");
        lList.addLast("la");

        lList.remove();
        lList.remove("ff");
        lList.remove(1);

        lList.indexOf("KB");

        lList.add(null);
        lList.add(null);
        lList.add(null);

        lList.get(2);

        Iterator<String> it = lList.listIterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        ListIterator<String> it1 = lList.listIterator(1);
        it1.add("666");
        it1.add("777");
        while(it1.hasNext()){
            System.out.println(it1.next());
        }
        System.out.println(lList.toString());
        it1.remove();
        /**
         java.lang.IllegalStateException
         at java.util.LinkedList$ListItr.remove(LinkedList.java:921)
         at linkedList.LinkedListTest.main(LinkedListTest.java:50)

         */
        //listIterator的remove只能调用一次？
        //不是，是调用remove()之前，必须调用next()或者previous()：给lastNext赋值，才能删除
        //it1.remove();
        System.out.println(lList.toString());
        ListIterator<String> it2 = lList.listIterator(5);
        while(it2.hasNext()){
            System.out.println(it2.next());
            it2.remove();
            System.out.println("removed");
        }
        System.out.println(lList.toString());
        ListIterator<String> it3 = lList.listIterator(3);
        while(it3.hasPrevious()){
            System.out.println(it3.previous());
            it3.remove();
            System.out.println("removed");
        }
        System.out.println(lList.toString());
    }
}
