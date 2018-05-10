package ZAD_11_Buffer;

public class Main {
    public static void main(String[] args) {



        Buffer buffer = new Buffer();
        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);

        try {
            for(int t: buffer.tab){
                System.out.println(t);
            }
            //producer.buffer.get();
            //consumer.buffer.put(2);
            Thread.sleep(15000);
        }catch (InterruptedException e){
            System.out.println("InterruptedException Main");
            return;
        }


    }
}
