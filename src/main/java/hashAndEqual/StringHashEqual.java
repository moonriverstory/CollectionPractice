package hashAndEqual;

public class StringHashEqual {
    public static void main(String[] args) {
        String a = "AA";
        String b = "AA";
        String c = new String("AA");
        String d = new String("AA");
        String e = a;
        System.out.println("a = b "+ (a==b));
        System.out.println("b = c "+ (b==c));
        System.out.println("c = d "+ (c==d));
        System.out.println("e = b "+ (e==b));
        System.out.println("a equals b "+ (a.equals(b)));
        System.out.println("b equals c "+ (b.equals(c)));
        System.out.println("c equals d "+ (c.equals(d)));
        System.out.println("a hashcode "+ a.hashCode());
        System.out.println("b hashcode "+ b.hashCode());
        System.out.println("c hashcode "+ c.hashCode());
        System.out.println("d hashcode "+ d.hashCode());
        //hash code和对象地址没什么关系=。= 很神奇
    }
}
