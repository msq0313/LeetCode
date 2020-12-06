package DesignPatterns.SimpleFactory;

public class Pear extends Fruit {
    String color = "yellow";

    @Override
    public void eat() {
        System.out.println("吃梨");
    }
}
