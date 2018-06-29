package ZAD_22_MiniBazaDanychMVC;

import java.time.LocalDate;

public class Pracownik {
    String imie;
    String nazwisko;
    int wiek;
    String Stanowisko;
    int rocznik;

    Object[] tab;



    int nowYear;


    public Pracownik(String imie, String nazwisko, String stanowisko, int rocznik) {
        nowYear = LocalDate.now().getYear();
        this.imie = imie;
        this.nazwisko = nazwisko;
        setWiek(rocznik);
        Stanowisko = stanowisko;
        this.rocznik = rocznik;

        tab = new Object[]{this.imie, this.nazwisko, this.wiek, this.Stanowisko, this.rocznik};
    }

    public void setWiek(int rocznik) {
        this.wiek = nowYear - rocznik;
    }

    public Object[] getTab() {
        return tab;
    }
}
