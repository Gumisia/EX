package ZAD_4_Reversible;


public class ReversibleInt implements Reversible{

    int liczba;

    ReversibleInt(int liczba){
        this.liczba=liczba;
    }

    public Reversible reverse(){
        liczba=liczba*(-1);
        return this;
    }

    public  Reversible zmiana(){
        reverse();
        liczba = liczba+10;
        return this;
    }

    @Override
    public String toString() {
        return " "+liczba;
    }
}
