// The ConcertTicket decorator
abstract class ConcertTicketDecorator implements ConcertTicket {
    private final ConcertTicket decoratedTicket;


    public ConcertTicketDecorator(ConcertTicket decoratedTicket){
        this.decoratedTicket = decoratedTicket;
    }


    public String getDescription() {
        return decoratedTicket.getDescription();
    }


    public double getCost() {
        return decoratedTicket.getCost();
    }
}
