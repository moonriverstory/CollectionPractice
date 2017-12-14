package hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 *HashMapIterator fail fast 测试
 */
public class FailFastTest {
    public static void main(String[] args) {

        Map<String, Integer> nameAgeMap = new HashMap<>();

        nameAgeMap.put("One", 1);
        nameAgeMap.put("Two", 2);
        nameAgeMap.put("Three", 3);
        nameAgeMap.put(null, 4);
        nameAgeMap.put("five", null);

        for (Map.Entry<String, Integer> entry : nameAgeMap.entrySet()) {
            if(null == entry.getKey()) {
                nameAgeMap.remove(null);
            }
            System.out.println(entry.getKey() + ' ' + entry.getValue());
        }

    }
    /**
     null 4
     Exception in thread "main" java.util.ConcurrentModificationException
     at java.util.HashMap$HashIterator.nextEntry(HashMap.java:922)
     at java.util.HashMap$EntryIterator.next(HashMap.java:962)
     at java.util.HashMap$EntryIterator.next(HashMap.java:960)
     at hashmap.FailFastTest.main(FailFastTest.java:17)
     */
}
