import java.util.Arrays;
import java.util.LinkedList;

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
    }
}
