package DesignPatterns.Singleton.饿汉式;

public class Singleton {
    // 线程安全，未实现懒加载效果，类加载时就初始化，浪费内存
    private static final Singleton instance = new Singleton();

    private Singleton() {

    }

    public static Singleton getInstance() {
        return instance;
    }
}
