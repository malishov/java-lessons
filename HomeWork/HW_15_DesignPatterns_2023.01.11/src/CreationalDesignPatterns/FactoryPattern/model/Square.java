package CreationalDesignPatterns.FactoryPattern.model;

import CreationalDesignPatterns.FactoryPattern.model.Shape;

public class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Square");
    }
}
