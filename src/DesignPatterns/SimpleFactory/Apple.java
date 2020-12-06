package DesignPatterns.SimpleFactory;

public class Apple extends Fruit {
    String color = "red";

    @Override
    public void eat() {
        System.out.println("吃苹果");
    }
}
