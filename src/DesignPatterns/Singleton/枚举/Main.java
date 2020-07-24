package DesignPatterns.Singleton.枚举;

public class Main {
    public static void main(String[] args) {
        Singleton singleton = Singleton.INSTANCE;
        singleton.showMessage();
    }
}
