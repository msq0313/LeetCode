package Basic.childUseFather;

public class ChildUseFather {
    public class Father {
        public void sayHello() {
            System.out.println("hello");
        }
    }

    public class Child extends Father {
        Father father = new Father();
    }

    public static void main(String[] args) {
        ChildUseFather childUseFather = new ChildUseFather();
        childUseFather.new Father().sayHello();
        childUseFather.new Child().father.sayHello();
    }
}