package DesignPatterns.Singleton.懒汉式;

public class Singleton {
    // 懒汉式线程不安全
    private static Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void show() {
        System.out.println("hello");
    }
}
