package CreationalDesignPatterns.AbstractFactoryPattern.model;

import CreationalDesignPatterns.FactoryPattern.model.Shape;

public class RoundedSquare implements Shape {
    @Override
    public void draw() {
        System.out.println("RoundedSquare");
    }
}
