package ZAD_10_StringTask;

public class StringTask implements Runnable{

    Thread t;

    String txt;
    int powtorzNapis;

    TaskState taskState;

    static boolean done;

    String result;



    StringTask(String napis, int powtorzNapis){

        this.txt = napis;
        this.powtorzNapis = powtorzNapis;

        t = new Thread(this, "Wątek StringTask");
        System.out.println("Utworzony watek: "+ t);

        taskState = TaskState.CREATED;
    }

    public void start(){
        t.start();
    }

    public void abort(){

        try{
                done = true;
                Thread.sleep(300);

        } catch(InterruptedException e){
            System.out.println("error abort");
        }
    }

    public boolean isDone(){

        return done;
    }

    @Override
    public void run() {

        taskState = TaskState.RUNNING;
        for(int i=0; i>powtorzNapis; i++){
            result = result + txt + " ";
        }
        taskState = TaskState.READY;
        done = true;

    }

    public TaskState getState(){
        return taskState;
    }

    public String getResult(){
        return result;
    }

    public String getTxt() {
        return txt;
    }

}
