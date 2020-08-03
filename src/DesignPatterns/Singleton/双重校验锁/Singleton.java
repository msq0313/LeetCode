package DesignPatterns.Singleton.双重校验锁;

public class Singleton {
    // 禁止指令重排序优化
    private volatile static Singleton INSTANCE;

    private Singleton() {}

    public static Singleton getInstance() {
        if (INSTANCE == null) {
            synchronized (Singleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Singleton();
                }
            }
        }
        return INSTANCE;
    }

    public void showMessage() {
        System.out.println("hello world");
    }
}
