package ClassLoader;

/*
A的静态字段 : 0
A的静态代码块
B的静态字段 : 0
B的静态代码块
A的成员变量  : 0
A的非静态代码块
A的构造器
B的成员变量 : 0
B的非静态代码块
B的有参构造
 */

public class Example0 {
    public static void main(String[] args) {
        B0 anotherB = new B0(1);// 思考有参构造的输出结果
    }
}

class A0 {
    //父类静态成员变量
    private static int numA;
    //父类成员变量
    private int numA2;
    //父类静态代码块
    static {
        System.out.println("A的静态字段 : " + numA);
        System.out.println("A的静态代码块");
    }
    //父类代码块
    {
        System.out.println("A的成员变量  : " + numA2);
        System.out.println("A的非静态代码块");
    }
    //父类无参构造
    public A0() {
        System.out.println("A的构造器");
    }
    //父类有参构造
    public A0(int n) {
        System.out.println("A的有参构造");
        this.numA2 = n;
    }
}

class B0 extends A0 {
    //子类静态成员变量
    private static int numB;
    //子类成员变量
    private int numB2;
    //子类静态代码块
    static {
        System.out.println("B的静态字段 : " + numB);
        System.out.println("B的静态代码块");
    }
    //子类代码块
    {
        System.out.println("B的成员变量 : " + numB2);
        System.out.println("B的非静态代码块");
    }
    //子类无参构造
    public B0() {
        System.out.println("B的构造器");
    }
    //子类有参构造
    public B0(int n) {
        System.out.println("B的有参构造");
        this.numB2 = n;
    }
}

