package CreationalDesignPatterns.AbstractFactoryPattern.model;

import CreationalDesignPatterns.FactoryPattern.model.Shape;

public class RoundedRectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("RoundedRectangle");
    }
}
