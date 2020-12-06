package DesignPatterns.FactoryMethod;

public class N95MaskFactory {
    public Mask create() {
        return new N95Mask();
    }
}