package ZAD_3_Muzyk;


public class Wiolonczelista extends Muzyk{

    Wiolonczelista(String imie, double czas){
        super(imie,czas);
    }

    String instrument(){
        return "wiolonczela";
    }

    double stawka(){
        return 250.0;
    }
}
