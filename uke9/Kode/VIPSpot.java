// A specific ConcertTicket decorator - VIPSpot
class VIPSpot extends ConcertTicketDecorator {
    public VIPSpot(ConcertTicket decoratedTicket) {
        super(decoratedTicket);
    }


    @Override
    public String getDescription() {
        return super.getDescription() + ", VIP spot";
    }


    @Override
    public double getCost() {
        return super.getCost() + 300.0;
    }
}
