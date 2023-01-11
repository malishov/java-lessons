import CreationalDesignPatterns.AbstractFactoryPattern.AbstractFactory;
import CreationalDesignPatterns.AbstractFactoryPattern.FactoryProducer;
import CreationalDesignPatterns.BuilderPattern.Meal;
import CreationalDesignPatterns.BuilderPattern.MealBuilder;
import CreationalDesignPatterns.FactoryPattern.model.Shape;

public class Main {
    public static void main(String[] args) {

//        SingleObject singleObject = SingleObject.getInstance();
//        singleObject.showMessage();

//        ShapeFactory shapeFactory = new ShapeFactory();
//        Shape shape1 = shapeFactory.getShape("CIRCLE");
//        shape1.draw();

//        AbstractFactory shapeFactory = FactoryProducer.getFactory(true);
//        Shape shape1 = shapeFactory.getShape("RECTANGLE");
//        shape1.draw();

        MealBuilder mealBuilder = new MealBuilder();

        Meal vegMeal = mealBuilder.prepareVegMeal();
        System.out.println("Veg Meal");
        vegMeal.showItems();
        System.out.println("Total Cost: " + vegMeal.getCost());

    }
}
