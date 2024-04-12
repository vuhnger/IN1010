class Counter implements Runnable{
    
    private final int MAX_COUNT = 10_000; 
    private int count = 0;

    public void run(){
        System.out.println("Starter, antall er: " + count);
        for (int i = 0; i < MAX_COUNT; i++){
            count++;
        }
        System.out.println("Ferdig, antall er: " + count);
    }
}

public class CounterMain {
    public static void main(String[] args) {
        Runnable task = new Counter();

        // Hva skjer når to tråder deler samme oppgave?
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start(); t2.start();

        // Ulikt svar hver gang!
    }
}
