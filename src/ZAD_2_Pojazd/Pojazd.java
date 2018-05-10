package ZAD_2_Pojazd;


import java.time.LocalDate;


public class Pojazd {
    String marka;
    String model;
    int rok_produkcji;
    LocalDate data_rejestracji;

    Pojazd(String marka, String model, int rok_produkcji, LocalDate data_rejestracji){
        this.marka = marka;
        this.model = model;
        this.rok_produkcji = rok_produkcji;
        this.data_rejestracji = data_rejestracji;
    }

    public String toString(){
        return "marka: "+marka+" model: "+model+" rok produkcji "+rok_produkcji+" data rejstracji "+data_rejestracji;
    }
}
