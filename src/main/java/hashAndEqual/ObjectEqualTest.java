package hashAndEqual;

public class ObjectEqualTest {

    public static void main(String[] args) {
        PersonPojo p1 = new PersonPojo("pp", "1");
        PersonPojo p2 = new PersonPojo("pp", "1");

        System.out.println("p1: " + p1.toString());
        System.out.println("p2: " + p2.toString());

        System.out.println("p1 hash code: " + p1.hashCode());
        System.out.println("p2 hash code: " + p2.hashCode());

        System.out.println("p1 == p2: " + (p1 == p2));
        System.out.println("p2 equals p2: " + (p1.equals(p2)));
    }
}
/**
 p1: hashAndEqual.PersonPojo@1b231
 p2: hashAndEqual.PersonPojo@1b232
 p1 hash code: 111153
 p2 hash code: 111154
 p1 == p2: false
 p2 equals p2: false
 */
/**
 p1: hashAndEqual.PersonPojo@1b231
 p2: hashAndEqual.PersonPojo@1b231
 p1 hash code: 111153
 p2 hash code: 111153
 p1 == p2: false
 p2 equals p2: false
 */
//这个结果证明，两个对象即使重写了hashcode()方法，hashcode相同，
//但是不重写equals方法的话，也是不相等的
/**
 //object的equals方法，看起来是不是很扯淡，根本没有调用hashcode，而是直接用==比较地址是否相同，嗯哼=。=

 public boolean equals(Object obj) {
 return (this == obj);
 }
 */
/**
 p1: hashAndEqual.PersonPojo@1b231
 p2: hashAndEqual.PersonPojo@1b231
 p1 hash code: 111153
 p2 hash code: 111153
 p1 == p2: false
 p2 equals p2: true
 */
//重写了equals方法就相等了，但是，其实两个对象的地址是不同的，是两个对象=。=
