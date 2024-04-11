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
