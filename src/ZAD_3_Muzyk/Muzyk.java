package ZAD_3_Muzyk;

abstract class Muzyk {
    protected String imie;
    protected double czas;


    abstract String instrument();
    abstract double stawka();

    String imie(){
        return imie;
    }

    double czas(){
        return czas;
    }

    Muzyk(String imie, double czas){
        this.imie=imie;
        this.czas=czas;
    }

    static Muzyk maxHonorarium(Muzyk[] tab){

        Muzyk maxi=tab[0];
        double max=tab[0].stawka()*tab[0].czas();


        for(int i=1; i<tab.length; i++){
            if(max<=tab[i].stawka()*tab[i].czas()){
                max=tab[i].stawka()*tab[i].czas();
                maxi=tab[i];}
        }

        return maxi;
    }

    @Override
    public String toString() {

        return  imie+", czas = "+czas+" godz., stawka = "+stawka();

        //Aleks, czas = 2.0 godz., stawka = 200.0
    }
}
