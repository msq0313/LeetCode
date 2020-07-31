package ClassLoader;

public class Example1 {
    public static void main(String[] args) {
        System.out.print(fun1());

    }
    public static String fun1() {
        try {
            System.out.print("A");
            return fun2();
        } finally {
            System.out.print("B");
        }
    }
    public static String fun2() {
        System.out.print("C");
        return "D";
    }
}
