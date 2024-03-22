// A ConcertTicket implementation
class BasicConcertTicket implements ConcertTicket {
    @Override
    public String getDescription() {
        return "Concert ticket";
    }


    @Override
    public double getCost() {
         return 450.0;
    }


    void test(){
        System.out.println("hei");
    }
}
