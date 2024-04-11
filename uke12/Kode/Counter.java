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