package ZAD_9_Spiewak_cd;

public class ChorTest {

    public static void main(String[] args) throws InterruptedException {
        Chor chor = new Chor("ABC");
        for (Thread t : chor.getThreads()) System.out.println(t.getName());

        for(Thread listaSpiewkow: chor.getThreads()){
            listaSpiewkow.start();
        }

        Thread.sleep(10000);

        /*<- tu trzeba zapisać
           fragment, który kończy działanie kodów, wypisujących znaki
        */

        for(Thread listaSpiewakow: chor.getThreads()){
            listaSpiewakow.interrupt();
        }

        System.out.println("\nProgram skończył działanie");
    }

}
