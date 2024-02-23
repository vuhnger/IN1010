public abstract class ElVare extends Vare{

    protected int batteriTid, aarSidenKjop;
    private static final double MVA = 0.3;

    public ElVare(double pris, int batteriTid, int aarSidenKjop){
        super(pris);
        batteriTid = this.batteriTid; // Skille på argument og instansvariabel!
        aarSidenKjop = this.aarSidenKjop; // Skille på argument og instansvariabel!
    }

    public double beregnBatteriTid() {
        return batteriTid;
    }

    @Override
    public double beregnFullPris(){
        return pris + pris * MVA;
    }

    @Override
    public void skrivVare()  {
        System.out.println("Batteritid: " + beregnBatteriTid());
        System.out.println("Aar siden kjop: " + aarSidenKjop);
        super.skrivVare();
    }
}
