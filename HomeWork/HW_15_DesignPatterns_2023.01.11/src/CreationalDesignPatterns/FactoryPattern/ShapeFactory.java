package CreationalDesignPatterns.FactoryPattern;

import CreationalDesignPatterns.FactoryPattern.model.Circle;
import CreationalDesignPatterns.FactoryPattern.model.Rectangle;
import CreationalDesignPatterns.FactoryPattern.model.Shape;
import CreationalDesignPatterns.FactoryPattern.model.Square;

public class ShapeFactory {

    public Shape getShape(String shapeType) {

        if (shapeType == null) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square();
        } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        }

        return null;
    }
}
