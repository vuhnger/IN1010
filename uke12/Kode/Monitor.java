
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Monitor {
    public static void main(String[] args) {
        SharedCounter monitor = new SharedCounter();
        Runnable incrementer = new IncrementCounter(monitor);
        Runnable waiter = new WaitForCounter(monitor);
        Thread incremThread = new Thread(incrementer);
        Thread waiThread = new Thread(waiter);
        incremThread.start(); waiThread.start();
    }
}


// Dette er en monitor-klasse
class SharedCounter{
    private int counter = 0;
    private final Lock lock = new ReentrantLock();
    private final Condition counterReachedFive = lock.newCondition();

    void increment(){
        lock.lock();
        try{
            counter++;
            System.out.println("Telletråd: Teller økt til: " + counter);
            if (counter == 5){
                counterReachedFive.signalAll();
            }
        }finally{
            lock.unlock();
        }
    }

    void waitForCounterToReachFive() throws InterruptedException {
        lock.lock();
        try {
            while(counter < 5) {
                System.out.println("Ventetråd: Venter på at telleren skal nå 5...");
                counterReachedFive.await();
            }
            System.out.println("Ventetråd: Telleren har nådd 5!");
        } finally {
            lock.unlock();
        }
    }



}

class IncrementCounter implements Runnable{

    private final SharedCounter counter;
    IncrementCounter(SharedCounter counter){
        this.counter = counter;
    }

    @Override
    public void run(){
        for(int i = 0; i < 5; i++){
            counter.increment();
            try {
                Thread.sleep(1_000);
            } catch (InterruptedException e) {
                System.out.println("Tellingen ble avbrutt ... " + e.getMessage());
                System.exit(1);
            }
        }
    }

}

class WaitForCounter implements Runnable{
    private final SharedCounter counter;

    WaitForCounter(SharedCounter counter){
        this.counter = counter;
    }

    @Override
    public void run(){
        try{
            counter.waitForCounterToReachFive();
        }catch (InterruptedException e){
            System.out.println("Ventetråd ble avbrutt..");
            System.exit(1);
        }

    }
}
