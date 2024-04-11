
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args){
        Runnable r = new SafeCounter();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start(); t2.start();
    }
}

class SafeCounter implements Runnable{
    
    private final Lock lock = new ReentrantLock();
    private final int MAX_COUNT = 10_000;
    private int count = 0;

    public void run(){
        System.out.println("Starter å telle... " + getCount());
        for (int i = 0; i < MAX_COUNT; i++){
            lock.lock();
            try {
                count++;
            }finally{
                lock.unlock();
            }
        }
        System.out.println("Ferdig å telle til: " + getCount());
    }

    private int getCount(){
        lock.lock();
        try{
            return count;
        }finally{
            lock.unlock();
        }
    }
}