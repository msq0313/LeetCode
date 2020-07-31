package ClassLoader;

//JAVA的类加载期负责整个生命周期内的class的初始化和加载工作，
// 就虚拟机的规范来说，以下代码会输出什么结果？

public class Example5 {
    public static void main(String[] args) {
        System.out.println(E5.a);
    }
}
// 实例变量，需要初始化
class E5{
    public static final String a=new String("JD");
    static {
        System.out.print("OK");
    }
}
