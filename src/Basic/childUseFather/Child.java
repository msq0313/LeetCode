package Basic.childUseFather;

public class Child extends Father{
    public static void main(String[] args) {
        Father father = new Father();
        father.sayHello();
    }
}
