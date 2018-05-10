package ZAD_6_Spiewak;

//nowe ZAD_5

import java.util.Arrays;

public class Main {
    public static void main(String[] args)
    {
        Spiewak s1 = new Spiewak("Darrey"){
            @Override
            public String spiewaj() {
                return "eeae";
            }
            /*<-  kod */
        };
        Spiewak s2 = new Spiewak("Darrey"){
            @Override
            public String spiewaj() {
                return "bebe";
            }
            /*<-  kod */
        };
        Spiewak s3 = new Spiewak("Houston"){
            @Override
            public String spiewaj() {
                return "a4iBBiii";
            }

            /*<-  kod */
        };
        Spiewak s4 = new Spiewak("Carrey"){
            @Override
            public String spiewaj() {
                return "oaooooooooooo";
            }
            /*<-  kod */
        };
        //stworzyć kilka (co najmniej 3) obiektów-śpiewaków poprzez użycie anonimowych
        //klas wewnętrznych rozszerzających klasę Spiewak. Użycie tych klas polega na podawaniu tego,
        // co śpiewak ma śpiewać w konkursie

        Spiewak s5 = new Spiewak("Madonna"){
            @Override
            public String spiewaj() {
                return "aAa";
            }

            /*<-  kod */
        };

        Spiewak sp[] = {s1, s2, s3, s4, s5};

        Arrays.sort(sp);

        for (Spiewak s : sp)
            System.out.println(s);

//        System.out.println("\n" + Spiewak.najglosniej(sp));
    }
}
