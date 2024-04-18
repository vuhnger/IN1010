import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


class TacoTruck {
    public static final int TOTAL_TACOS = 50;
    public static final int NR_CUSTOMERS = 25;
    public static final int MAX_TACOS_ON_COUNTER = 2;
    public static final int TACO_MAKING_TIME_MS = 1000;


    private final Lock lock = new ReentrantLock();
    private final Condition counterIsFull = lock.newCondition();
    private final Condition counterIsEmpty = lock.newCondition();
    private int tacosOnCounter = 0;


    public void makeTaco() throws InterruptedException {
        lock.lock();
        try {
            while (tacosOnCounter >= MAX_TACOS_ON_COUNTER) {
                counterIsFull.await();
            }
            tacosOnCounter++;
            System.out.println("Chef made a taco. Tacos on counter: " + tacosOnCounter);
            counterIsEmpty.signalAll();
        } finally {
            lock.unlock();
        }
    }


    public void consumeTaco(int customerID) throws InterruptedException {
        lock.lock();
        try {
            while (tacosOnCounter == 0) {
                counterIsEmpty.await();
            }
            tacosOnCounter--;
            System.out.println("Customer " + customerID + " consumed a taco. Tacos left on counter: " + tacosOnCounter);
            counterIsFull.signalAll();
        } finally {
            lock.unlock();
        }
    }
}


class Chef implements Runnable {
    private final TacoTruck tacoTruck;
    public Chef(TacoTruck tacoTruck) {
        this.tacoTruck = tacoTruck;
    }


    @Override
    public void run() {
        try {
            for (int i = 0; i < TacoTruck.TOTAL_TACOS; i++) {
                Thread.sleep(TacoTruck.TACO_MAKING_TIME_MS);
                tacoTruck.makeTaco();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Chef was interrupted and stops making tacos.");
        }
    }
}


class Customer implements Runnable {
    private final TacoTruck tacoTruck;
    private final int customerID;
    private final CountDownLatch latch;
    public Customer(TacoTruck tacoTruck, int customerID, CountDownLatch latch) {
        this.tacoTruck = tacoTruck;
        this.customerID = customerID;
        this.latch = latch;
    }


    @Override
    public void run() {
        try {
            Thread.sleep(3000 + customerID*1000);
            tacoTruck.consumeTaco(customerID);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Customer " + customerID + " was interrupted before consuming a taco.");
        } finally {
            latch.countDown();
        }
    }
}


public class Main {
    public static void main(String[] args) {
        TacoTruck tacoTruck = new TacoTruck();
        CountDownLatch customerLatch = new CountDownLatch(TacoTruck.NR_CUSTOMERS);
        Thread chefThread1 = new Thread(new Chef(tacoTruck));
        Thread chefThread2 = new Thread(new Chef(tacoTruck));


        Thread[] customerThreads = new Thread[TacoTruck.NR_CUSTOMERS];
        for (int i = 0; i < TacoTruck.NR_CUSTOMERS; i++) {
            customerThreads[i] = new Thread(new Customer(tacoTruck, i + 1, 
            customerLatch));
        }


        chefThread1.start();
        for (Thread customerThread : customerThreads) {
            customerThread.start();
        }


        try {
            customerLatch.await();
            chefThread1.interrupt(); chefThread2.interrupt();
        } catch (InterruptedException e) {
            System.err.println("The main thread was interrupted while waiting for the customers. Program exits.");
            System.exit(1);
        }
       
        System.out.println("All customers are served. The foodtruck is closing!");
    }
}

