package ZAD_11_Buffer;

public class Consumer implements Runnable {

    Thread t;

    Buffer buffer;

    Consumer(Buffer b){
        t = new Thread(this, "Watek Consumer");
        System.out.println("Utworzenie Consumer: ");
        t.start();
        buffer = b;
    }

    @Override
    public void run() {


        while (true) {
                try {
                    if (buffer.lenght > 0) {
                        if (buffer.free) {
                            buffer.free = false;
                            System.out.println(this.buffer.get());
                            buffer.free = true;
                        }
                    }
                    int sleepTime = (int) (2001 * Math.random());
                    Thread.sleep(sleepTime);

                }catch (InterruptedException e){
                    System.out.println("InterruptedException Consumer");
                }
        }

    }
}
