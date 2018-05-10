package ZAD_9_Spiewak_cd;


import java.util.ArrayList;
import java.util.List;

public class Chor extends Thread{

    char[] tekst; //repertuar
    List<Spiewak> threadList = new ArrayList<>();

    Chor(String tekst){
//        super("Repertuar");
        this.tekst = tekst.toCharArray();

        for(int i=0; i< tekst.length(); i++){
            char znakZTekstu = this.tekst[i];

            threadList.add(new Spiewak("Spiewak " + znakZTekstu) {
                               public void run() {
                                   while (true) {
                                       spiewaj();
                                       try {
                                           Thread.sleep(2000);
                                       } catch (InterruptedException e) {
                                           return;
//                                           System.out.println("Przerwano działanie repertuaru");
                                       }
//                                       System.out.println("Wyjście z watku chóru");
                                   }
                               }

                @Override
                String spiewaj() {

                    if ((int)(2*Math.random()) > 0) {
                        System.out.print(Character.toUpperCase(znakZTekstu));
                    } else System.out.print(Character.toLowerCase(znakZTekstu));

                    return Character.toString(znakZTekstu);
                }
            });

        }
//        stworzSpiewakow(tekst.length());
    }

//    private void stworzSpiewakow(int liczba){
//
//    }



    public List<Thread> getThreads(){
        List<Thread> threads = new ArrayList<>();
        threads.addAll(threadList);
        return threads;
    }
}
