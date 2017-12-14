package hashmap;

import java.util.HashMap;
import java.util.Map;

public class MapExample {

    public static void main(String[] args) {
        String a = "Aa";
        String b = "BB";
        System.out.println("hashcode: " + a.hashCode());
        System.out.println("hashcode: " + b.hashCode());

        Map<String, Integer> nameAgeMap = new HashMap<>();
        nameAgeMap.put("Zhang", 24);
        nameAgeMap.put("Eric", 20);
        nameAgeMap.put("John", 21);
        nameAgeMap.put("LiLei", 19);
        nameAgeMap.put("Wang", 28);
        nameAgeMap.put("BB", 8);
        nameAgeMap.put("Aa", 7);
        System.out.println(nameAgeMap);
        /**
         hashcode: 2112
         hashcode: 2112
         {Zhang=24, Wang=28, LiLei=19, Eric=20, John=21}
         */
        /**
         hashcode: 2112
         hashcode: 2112
         {Zhang=24, Wang=28, BB=8, Aa=7, LiLei=19, Eric=20, John=21}
         */
        /**
         hashcode: 2112
         hashcode: 2112
         {Zhang=24, Wang=28, Aa=7, BB=8, LiLei=19, Eric=20, John=21}
         */
        //怎么说呢，从执行结果来看，hashcode相同的，可能是个链表，但是debug里面观察，看不到链表结构，尴尬啊=。=
        //配置一下variables视图就可以看到了！
        //这里：hashcode不同，计算出的位置也不相同，固定不变；hashcode相同，计算出的位置按照put倒序=。=？
        //是的，链表是倒序，后插入的总在前面！

    }
}

