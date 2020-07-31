package ClassLoader;

//根据类加载器加载类的初始化原理，推断以下代码的输入结果为？

public class Example2 {
    public static void main(String[] args) {
        System.out.print(B.c);
    }
}
// 子类调用父类成员变量，父类先初始化
class A {
    public static String c = "C";
    static {
        System.out.print("A");
    }
}

class B extends A{
    static {
        System.out.print("B");
    }
}