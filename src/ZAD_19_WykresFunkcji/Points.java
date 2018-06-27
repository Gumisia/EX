package ZAD_19_WykresFunkcji;

import java.util.Map;

public class Points {

    String formula;
    Map<String, Integer> map;
    Vector vector;
    PolynomialFunction polynomialFunction;

    int sizePoints;
    double proportionsX;
    double proportionsY;

    int tabX[];
    int tabY[];

    int realTabX[];
    int realTabY[];

    int drawtabX[];
    int drawtabY[];


    Points(String formula, Map<String, Integer> map, Vector vector){
        sizePoints=400;
        tabX = new int[sizePoints];
        tabY = new int[sizePoints];
        drawtabX = new int[sizePoints];
        drawtabY = new int[sizePoints];

        this.formula = formula;
        this.map = map;
        this.vector = vector;

        proportionsX=(double)vector.getWidth()/(double)sizePoints;
        proportionsY=(double)vector.getHight()/(double)sizePoints;

        polynomialFunction = new PolynomialFunction(this.formula, sizePoints, map.get("xMin"), map.get("xMax"));

        calculateX();
        calculateY();
    }

    void calculateX(){
        realTabX = polynomialFunction.getTabX();
        for(int i=0; i<sizePoints; i++){
            tabX[i]=(int)((double)realTabX[i]*proportionsX);
        }
    }

    void calculateY(){
        realTabY = polynomialFunction.getTabY();
        for(int i=0; i<sizePoints; i++){
            tabY[i]=(int)((double)realTabY[i]*proportionsY);
        }
    }

    public int[] getTabX() {

        for (int i=0; i<tabX.length; i++) {
            drawtabX[i]=(vector.getXVector()+(int)((double)tabX[i]*proportionsX));
        }
        return drawtabX;

    }

    public int[] getTabY() {
        for(int i=0; i<tabY.length; i++){
            drawtabY[i]=vector.getYVector()+(int)((double)tabY[i]*proportionsY);
        }
        return drawtabY;
    }
}
