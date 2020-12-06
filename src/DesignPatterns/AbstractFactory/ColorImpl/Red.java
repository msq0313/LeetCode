package DesignPatterns.AbstractFactory.ColorImpl;

import DesignPatterns.AbstractFactory.Color;

public class Red implements Color {

    @Override
    public void fill() {
        System.out.println("Inside Red::fill() method.");
    }
}