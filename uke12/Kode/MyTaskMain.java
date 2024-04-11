
public class MyTaskMain {

    public static void main(String[] args) {
        Runnable task = new MyTask(10);
        Thread thr = new Thread(task);
        thr.start();        
    }
}
