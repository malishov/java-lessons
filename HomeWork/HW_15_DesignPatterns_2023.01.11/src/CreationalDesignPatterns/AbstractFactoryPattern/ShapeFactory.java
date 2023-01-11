package CreationalDesignPatterns.AbstractFactoryPattern;

import CreationalDesignPatterns.FactoryPattern.model.Rectangle;
import CreationalDesignPatterns.FactoryPattern.model.Shape;
import CreationalDesignPatterns.FactoryPattern.model.Square;

public class ShapeFactory extends AbstractFactory{
    @Override
    public Shape getShape(String shapeType) {

        if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        }else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }
}
