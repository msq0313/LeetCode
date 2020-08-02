package DesignPatterns.Singleton.双重校验锁;

public class Singleton {
    private volatile static Singleton singleton;

    private Singleton() {}

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    public void showMessage() {
        System.out.println("hello world");
    }
}
