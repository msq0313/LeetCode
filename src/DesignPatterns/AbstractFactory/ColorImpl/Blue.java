package DesignPatterns.AbstractFactory.ColorImpl;

import DesignPatterns.AbstractFactory.Color;

public class Blue implements Color {

    @Override
    public void fill() {
        System.out.println("Inside Blue::fill() method.");
    }
}