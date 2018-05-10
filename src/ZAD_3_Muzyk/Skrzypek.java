package ZAD_3_Muzyk;


public class Skrzypek extends Muzyk{

    Skrzypek(String imie, double czas){
        super(imie,czas);
    }
    String instrument(){
        return "skrzypce";
    }

    double stawka(){
        return 200.0;
    }
}

