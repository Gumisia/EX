package ZAD_3_Muzyk;


public class Flecista extends Muzyk {

    Flecista(String imie, double czas){
        super(imie,czas);
    }

    String instrument(){
        return "flet";
    }

    double stawka(){
        return 300.0;
    }

}
