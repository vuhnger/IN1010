import java.util.concurrent.CountDownLatch;


/*
 * Her bruker vi barrieren CountDownLatch istedenfor join(). CountDownLatch-objekter
 * kan deles mellom flere tråder. 
 */

public class TacoPreparationLatch {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(2);


        Thread vegetableThread = new Thread(new ChopVegetablesTask(latch));
        Thread meatThread = new Thread(new CookMeatTask(latch));
        Thread tortillaThread = new Thread(new HeatTortillasTask(latch));


        vegetableThread.start(); 
        meatThread.start(); 
        tortillaThread.start();
    }
}


class ChopVegetablesTask implements Runnable {
    private final CountDownLatch latch;


    ChopVegetablesTask(CountDownLatch latch) {
        this.latch = latch;
    }


    @Override
    public void run() {
        try {
            String[] vegetables = {"Tomato", "Lettuce", "Onion"};
            for (String veggie : vegetables) {
                System.out.println("Chopping " + veggie);
                Thread.sleep((int) (Math.random() * 2500));
            }
            System.out.println("All vegetables chopped!");
            latch.countDown();
        } catch (InterruptedException e) {
            System.err.println("Vegetable chopping was interrupted. Dinner is cancelled!");
            System.exit(1);
        }
    }
}


class CookMeatTask implements Runnable {
    private final CountDownLatch latch;
    CookMeatTask(CountDownLatch latch) {
        this.latch = latch;
    }
    @Override
    public void run() {
        try {
            System.out.println("Cooking meat");
            Thread.sleep((int) (Math.random() * 5000));
            System.out.println("Meat cooked!");
            latch.countDown();
        } catch (InterruptedException e) {
            System.err.println("Meat cooking was interrupted. Dinner is cancelled!");
            System.exit(1);
        }
    }
}


class HeatTortillasTask implements Runnable {
    private final CountDownLatch latch;
    HeatTortillasTask(CountDownLatch latch) {
        this.latch = latch;
    }


    @Override
    public void run() {
        try {
            latch.await();
            System.out.println("Heating tortillas");
            Thread.sleep((int) (Math.random() * 3000));
            System.out.println("Tortillas heated!");
        } catch (InterruptedException e) {
            System.err.println("Tortilla heating was interrupted while waiting for other tasks. Dinner is cancelled!");
            System.exit(1);
        }
    }
} 

