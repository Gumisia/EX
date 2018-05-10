package ZAD_2_Pojazd;


import java.time.LocalDate;

public class Taksowka extends Samochod {
    //Każdy przegląd okresowy ważny jest przez 365 dni dla samochodu oraz 6 miesięcy dla taksówki.

    LocalDate data_waz_taksometru;


    Taksowka(String marka, String model, int rok_produkcji, LocalDate data_rejestracji, LocalDate data_ost_przegladu, LocalDate data_waz_ost_ubesp, LocalDate data_waz_taksometru){
        super(marka,model,rok_produkcji,data_rejestracji,data_ost_przegladu,data_waz_ost_ubesp);
        this.data_waz_taksometru = data_waz_taksometru;

    }

    public void setData_waz_taksometru(LocalDate data_waz_taksometru) {
        this.data_waz_taksometru = data_waz_taksometru;
    }

    public boolean check_przeglad(){
        LocalDate akt = LocalDate.now();
        return data_ost_przegladu.plusDays(183).isBefore(akt);
    }

    boolean check_taksom(){
        LocalDate akt = LocalDate.now();
        return  data_waz_taksometru.isBefore(akt);
    }

    //Klasy Samochod i Taksówka posiadają metodę (pobierającą aktualna datę) sprawdzającą
    //czy samochód/taksówka posiada ważny przegląd okresowy/ubezpieczenie/taksometr.


    public String toString() {
        return "marka:" + marka + " model:" + model + " rok produkcji:" + rok_produkcji + " data rejstracji:" + data_rejestracji + " data ost. przegladu:" + data_ost_przegladu + " data waz. ost.ubesp:" + data_waz_ost_ubesp + " waż. taksometru:" + data_waz_taksometru;
    }

}
