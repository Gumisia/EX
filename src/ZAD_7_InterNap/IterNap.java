package ZAD_7_InterNap;

import java.util.Iterator;
import java.util.function.Consumer;

public class IterNap implements Iterable {

    char[] tekst;

    public IterNap(String tekst) {
        this.tekst = tekst.toCharArray();
    }

//    public String getTekst() {
//        return tekst;
//    }
//
//    public void setTekst(String tekst) {
//        this.tekst = tekst;
//    }

    void ustawPoczatek(int poczatek){

    }

    void ustawKrok(int krok){

    }

    @Override
    public void forEach(Consumer action) {

    }

    @Override
    public Iterator iterator() {
        return null;
    }
}
