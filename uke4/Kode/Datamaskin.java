

public class Datamaskin extends ElVare{

    private int RAM;
    private String merke;
    private double batteriStatus;

    public Datamaskin(double pris, int batteri, int aarKjop,
    int RAM, String merke, double batteriStatus) {
        super(pris,batteri,aarKjop);
        this.RAM = RAM;
        this.merke = merke;
        this.batteriStatus = batteriStatus;
    }

    @Override
    public double beregnBatteriTid() {
        return batteriTid + batteriStatus;
    }

    public int hentRAM() {
        return RAM;
    }

    @Override
    public void skrivVare() {
        System.out.println("Datamaskin fra: " + merke);
        System.out.println("RAM: " + merke);
        super.skrivVare();
    }
}
