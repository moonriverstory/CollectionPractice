package linkedhashset;

import java.util.LinkedHashSet;

public class LinkedHashSetTest {

    public static void main(String[] args) {
        LinkedHashSet<String> lset = new LinkedHashSet<>();
        lset.add("语文");
        lset.add("数学");
        lset.add("英语");
        lset.add("历史");
        lset.add("政治");
        lset.add("地理");
        lset.add("生物");
        lset.add("化学");
        lset.add("物理");

        //因为hashset把里面的值，存为hashmap中的key
        //这样，里面的值就不会重复了；如果重复add相同的值，则旧值覆盖新值，而不会报错=。= OK~
        lset.add("语文");
        lset.add("语文");
        lset.add("语文");
        for (String str : lset) {
            System.out.println(str);
        }
    }
}
