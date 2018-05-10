package ZAD_6_Spiewak;


abstract public class Spiewak implements Comparable<Spiewak>{

    static int lp;
    String nazwisko;
    int numer_startowy;
    int znaki;

    Spiewak(String nazwisko){
        this.nazwisko = nazwisko;
        znaki = iloscRoznychZnakow(this.spiewaj().toUpperCase().toCharArray());
        lp++;
        numer_startowy=lp;
    }

    abstract String spiewaj(); //zwraca tekst śpiewany przez śpiewaka w konkursie

    @Override // metoda ktora jest wymagana przez Comparable<T>
    public int compareTo(Spiewak o) {
        int znaki_obiektu = o.znaki;
        int numer_start = o.numer_startowy;
            if(znaki > znaki_obiektu)
                return  -1;
            else if(znaki < znaki_obiektu)
                return 1;
            else if(this.nazwisko.compareTo(o.nazwisko) < 0)
                return -1;
            else if(this.numer_startowy > numer_start)
                return 1;
            else if(this.numer_startowy < numer_start)
                return -1;
            else return 0;

//        return nazwisko.compareTo(o.nazwisko);
    }

    public String toString(){
        return "("+numer_startowy+") "+nazwisko + " : " + spiewaj();
    } //zwracającą informację o śpiewaku.

    static Spiewak najglosniej(Spiewak[] tab){

        Spiewak maxspiew = tab[0];
        int max=0;
        String wyspiewanytekst;


        for (Spiewak s : tab) {
//            wyspiewanytekst = (s.spiewaj()).toUpperCase();
//            char[] tabOfChars = wyspiewanytekst.toCharArray();

//            int iloscZnakow = iloscRoznychZnakow(wyspiewanytekst.toCharArray());

                    if(max<s.znaki) {
                        max = s.znaki;
                        maxspiew = s;
                    }
        }


        return maxspiew;
        }

        static public int iloscRoznychZnakow(char[] tabOfChars){

            int[] litery = new int[26];

            for (int i = 0; i < tabOfChars.length; i++) {


                if (Character.isLetter(tabOfChars[i])) litery[tabOfChars[i] - 'A']++;

//                    for (int j = 0; j < 26; j++)
//                    {
//                        if(Character.isUpperCase(tabOfChars[i])) litery[tabOfChars[i]-'A']++;
//                    }
            }

            int rozneznaki = 0;

            for(int j=0; j<litery.length; j++){
                if(litery[j]>0)rozneznaki++;
            }
            return rozneznaki;
        }



    }//zwracającą obiekt-śpiewaka, w którego śpiewanym tekście znajduje się najwięcej różnych liter



