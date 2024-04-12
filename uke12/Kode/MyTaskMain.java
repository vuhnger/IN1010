class MyTask implements Runnable{

    int num;
    MyTask(int num){ this.num = num;}

    public void run(){
        for (int i = num; i >= 1; i--){
            System.out.println("Teller ned ... " + i);
        }
    }
}

public class MyTaskMain {

    public static void main(String[] args) {
        Runnable task = new MyTask(10);
        Thread thr = new Thread(task);
        thr.start();        
    }
}
