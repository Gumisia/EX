package ZAD_2_Pojazd;


import java.time.LocalDate;

public class Test {
    public static void main(String[] args) {
        Samochod[] tabsam = new Samochod[2];
        Taksowka[] tabtaks = new Taksowka[2];

        tabsam[0] = new Samochod(
                "Opel",
                "Corsa",
                1996,
                LocalDate.of(1997,4,20),
                LocalDate.of(2018,1,30),
                LocalDate.of(2018,7,1));

        tabsam[1] = new Samochod(
                "Toyota",
                "Yaris",
                2000,
                LocalDate.of(2001,4,20),
                LocalDate.of(2017,1,30),
                LocalDate.of(2018,1,1));

        tabtaks[0] = new Taksowka(
                "BMW",
                "e36",
                2002,
                LocalDate.of(2003,4,20),
                LocalDate.of(2017,7,30),
                LocalDate.of(2018,1,1),
                LocalDate.of(2018,1,2));

        tabtaks[1] = new Taksowka(
                "Rover",
                "Sin",
                2005,
                LocalDate.of(2006,4,20),
                LocalDate.of(2017,12,30),
                LocalDate.of(2019,1,1),
                LocalDate.of(2018,7,2));

            for( Samochod pojazd : tabsam){
                System.out.println(pojazd);
                System.out.println("przeglad: "+ (!pojazd.check_przeglad()));
                System.out.println("ubespieczenie: "+ (!pojazd.check_ubesp()));
                System.out.println("");
            }

            for( Taksowka pojazd : tabtaks){
                System.out.println(pojazd);
                System.out.println("przeglad: "+ (!pojazd.check_przeglad()));
                System.out.println("ubespieczenie: "+ (!pojazd.check_ubesp()));
                System.out.println("taksometr: "+ (!pojazd.check_taksom()));
                System.out.println("");
            }


    }
}
