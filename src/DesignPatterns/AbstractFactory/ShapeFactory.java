package DesignPatterns.AbstractFactory;

import DesignPatterns.AbstractFactory.AbstractFactory;
import DesignPatterns.AbstractFactory.Color;
import DesignPatterns.AbstractFactory.Shape;
import DesignPatterns.AbstractFactory.ShapeImpl.Circle;
import DesignPatterns.AbstractFactory.ShapeImpl.Rectangle;
import DesignPatterns.AbstractFactory.ShapeImpl.Square;

public class ShapeFactory extends AbstractFactory {

    @Override
    public Shape getShape(String shapeType){
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        } else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }

    @Override
    public Color getColor(String color) {
        return null;
    }
}