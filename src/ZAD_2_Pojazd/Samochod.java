package ZAD_2_Pojazd;


import java.time.LocalDate;

public class Samochod extends Pojazd {

    //Każdy przegląd okresowy ważny jest przez 365 dni dla samochodu oraz 6 miesięcy dla taksówki.


    LocalDate data_ost_przegladu;
    LocalDate data_waz_ost_ubesp;

    Samochod(String marka, String model, int rok_produkcji, LocalDate data_rejestracji, LocalDate data_ost_przegladu, LocalDate data_waz_ost_ubesp)
    {
        super(marka,model,rok_produkcji,data_rejestracji);
        this.data_ost_przegladu = data_ost_przegladu;
        this.data_waz_ost_ubesp = data_waz_ost_ubesp;
    }

    public boolean check_przeglad(){
        LocalDate akt = LocalDate.now();
        return data_ost_przegladu.plusDays(365).isBefore(akt);
    }

    boolean check_ubesp(){
        LocalDate akt = LocalDate.now();
        return data_waz_ost_ubesp.isBefore(akt);
    }


    //mnow()


    public void setData_ost_przegladu(LocalDate data_ost_przegladu) {
        this.data_ost_przegladu = data_ost_przegladu;
    }

    public void setData_waz_ost_ubesp(LocalDate data_waz_ost_ubesp) {
        this.data_waz_ost_ubesp = data_waz_ost_ubesp;
    }

    //Klasy Samochod i Taksówka posiadają metodę (pobierającą aktualna datę) sprawdzającą
    //czy samochód/taksówka posiada ważny przegląd okresowy/ubezpieczenie/taksometr.


    public String toString(){
        return "marka:"+marka+" model:"+model+" rok produkcji:"+rok_produkcji+" data rejstracji:"+data_rejestracji+" data ost. przegladu:"+data_ost_przegladu+" data waz. ost.ubesp.:"+data_waz_ost_ubesp;
    }
}
