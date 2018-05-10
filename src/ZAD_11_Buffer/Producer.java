package ZAD_11_Buffer;

public class Producer implements Runnable {

    Thread t;

//    Producer producer;
    Buffer buffer;

    Producer(Buffer b){
        t = new Thread(this, "Watek Producer");
        System.out.println("Utworzenie Producer! ");
        t.start();
        buffer = b;
    }

    @Override
    public void run() {


            while (true) {
                try {
                int lp = (int) (10 * Math.random() + 1);
                if (this.buffer.free) {
                    this.buffer.free = false;
                    this.buffer.put(lp);
                    this.buffer.free = true;
                    }
                int sleepTime = (int) (2001 * Math.random());
                Thread.sleep(sleepTime);
                }
                catch(InterruptedException e){
                System.out.println("InterruptedException Producer");
                return;
                }
        }

    }
}
