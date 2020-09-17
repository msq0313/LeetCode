package Basic.childExtentsFather;
/*

 */

public class Main {

    public static class Father{
        static {
            System.out.println("static father");
        }
        {
            System.out.println("non-static father");
        }

        Father() {
            System.out.println("father");
        }
    }

    public static class Child extends Father {
        static {
            System.out.println("static child");
        }
        {
            System.out.println("non-static child");
        }

        Child() {
            System.out.println("child");
        }
    }


    public static void main(String[] args) {
        new Child();
    }
}