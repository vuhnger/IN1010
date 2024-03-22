public class DecoratorTest {

    static void testTicket(ConcertTicket t){
        System.out.println(t.getDescription()
        + "\n"
        + t.getCost());
    }


    public static void main(String[] args) {
        ConcertTicket ticket = new BasicConcertTicket();

        // Standard output
        testTicket(ticket);
        
        ticket = new VIPSpot(ticket);

        // VIP output
        testTicket(ticket);

    }
}
