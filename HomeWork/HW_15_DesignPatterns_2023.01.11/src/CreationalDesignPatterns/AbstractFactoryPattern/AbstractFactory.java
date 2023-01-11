package CreationalDesignPatterns.AbstractFactoryPattern;

import CreationalDesignPatterns.FactoryPattern.model.Shape;

public abstract class AbstractFactory {
    public abstract Shape getShape(String shapeType);
}
