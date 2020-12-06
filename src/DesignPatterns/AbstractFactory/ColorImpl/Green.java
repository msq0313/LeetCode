package DesignPatterns.AbstractFactory.ColorImpl;

import DesignPatterns.AbstractFactory.Color;

public class Green implements Color {

    @Override
    public void fill() {
        System.out.println("Inside Green::fill() method.");
    }
}