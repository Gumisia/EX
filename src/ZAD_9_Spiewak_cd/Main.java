package ZAD_9_Spiewak_cd;

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


        Spiewak s5 = new Spiewak("Madonna"){
            @Override
            public String spiewaj() {
                return "aAa";
            }

        };

        Spiewak sp[] = {s1, s2, s3, s4, s5};

        Arrays.sort(sp);

        for (Spiewak s : sp)
            System.out.println(s);

//        System.out.println("\n" + Spiewak.najglosniej(sp));
    }
}
