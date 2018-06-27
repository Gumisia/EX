package ZAD_19_WykresFunkcji;

import java.awt.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class Vector {
    double xVector;
    double yVector;

    Map<String, Integer> map;
    Dimension dimension;

    Vector(Map<String, Integer> map, Dimension dimension){
        this.map = new LinkedHashMap<>();
        this.map = map;
        this.dimension = dimension;
        calculateXVector();
        calculateYVector();
    }

    void calculateXVector(){

        double a = (-1)*map.get("xMin");
        double b = map.get("xMax");

        xVector = (dimension.width)*(
                a/(a+b)
        );

//        System.out.println("widthV = "+xVector);
    }
    void calculateYVector(){

        double a = (-1)*map.get("yMin");
        double b = map.get("yMax");

        yVector = (dimension.height)-((dimension.height)*(
                a/(a+b)
        ));

//        System.out.println("widthV = "+yVector);
    }

    public int getWidth() {
        return dimension.width;
    }

    public int getHight() {
        return dimension.height;
    }

    public int getXVector() {
        return (int)xVector;
    }

    public int getYVector() {
        return (int)yVector;
    }
}
