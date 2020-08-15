package DesignPatterns.Singleton.饿汉式;

public class Singleton {
    // 未实现懒加载效果
    private static final Singleton instance = new Singleton();

    private Singleton() {

    }

    public static Singleton getInstance() {
        return instance;
    }
}
