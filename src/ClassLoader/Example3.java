package ClassLoader;

public class Example3 {
    public static void main(String[] args) {
        System.out.print(B3.c);
    }
}
// 访问子类常量，不用初始化
class A3 {
    static {
        System.out.print("A");
    }
}

class B3 extends A3{
    static {
        System.out.print("B");
    }
    public final static String c = "C";
}
