package DesignPatterns.Singleton.双重校验锁;

public class Singleton {
    // 禁止指令重排序优化
    // INSTANCE = new Singleton();时，正常应该是先初始化再赋值
    // 但JVM有可能先赋值为实例对象，再初始化
    // 此时instance不为空，则会return一个未初始化的实例对象
    private volatile static Singleton INSTANCE;

    private Singleton() {}

    public static Singleton getInstance() {
        // 为了效率考虑，先判空
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
