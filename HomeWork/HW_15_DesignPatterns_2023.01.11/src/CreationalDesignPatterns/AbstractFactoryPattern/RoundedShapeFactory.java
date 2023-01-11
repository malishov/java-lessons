package CreationalDesignPatterns.AbstractFactoryPattern;

import CreationalDesignPatterns.AbstractFactoryPattern.model.RoundedRectangle;
import CreationalDesignPatterns.AbstractFactoryPattern.model.RoundedSquare;
import CreationalDesignPatterns.FactoryPattern.model.Shape;

public class RoundedShapeFactory extends AbstractFactory{
    @Override
    public Shape getShape(String shapeType) {

        if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new RoundedRectangle();
        }else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new RoundedSquare();
        }
        return null;
    }
}
