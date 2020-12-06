package DesignPatterns.FactoryMethod;

public class SurgicalMaskFactory{

    public Mask create() {
        return new SurgicalMask();
    }
}