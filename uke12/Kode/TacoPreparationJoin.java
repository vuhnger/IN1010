import java.util.ArrayList;
import java.util.Arrays;

/*
 * Her bruker vi join() som barriere i programmet.
 * Bemerk hvordan bruk av metoden join() tvinger main-tråden til å vente på at alle trådene er ferdige å eksekvere. 
 */

public class TacoPreparationJoin {
    public static void main(String[] args) {
        ArrayList<Thread> threads = new ArrayList<>(Arrays.asList(
            new Thread(new ChopVegetablesTask()),
            new Thread(new CookMeatTask()),
            new Thread(new HeatTortillasTask())
        ));

        threads.forEach(
            thread -> {thread.start();}
        );

        try {
            for (Thread t : threads){
                t.join();
            }
            System.out.println("All tasks are completed! Serve the tacos!");
        } catch (InterruptedException e) {
            System.err.println("Main thread was interrupted. Dinner is cancelled!");
            System.exit(1);
        }
    }}

class ChopVegetablesTask implements Runnable {
    @Override
    public void run() {
        try {
            String[] vegetables = {"Tomato", "Lettuce", "Onion"};
            for (String veggie : vegetables) {
                System.out.println("Chopping " + veggie);
                Thread.sleep((int)(Math.random() * 2500));
            }
            System.out.println("All vegetables chopped!");
        } catch (InterruptedException e) {
            System.err.println("Vegetable chopping was interrupted. Dinner is cancelled!");
            System.exit(1);
        }
    }
}


class CookMeatTask implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("Cooking meat");
            Thread.sleep((int)(Math.random() * 5000));
            System.out.println("Meat cooked!");
        } catch (InterruptedException e) {
            System.err.println("Meat cooking was interrupted. Dinner is cancelled!");
            System.exit(1);
        }
    }
}


class HeatTortillasTask implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("Heating tortillas");
            Thread.sleep((int)(Math.random() * 3000));
            System.out.println("Tortillas heated!");
        } catch (InterruptedException e) {
            System.err.println("Tortilla heating was interrupted. Dinner is cancelled!");
            System.exit(1);
        }
    }
}

