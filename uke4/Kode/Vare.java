public abstract class Vare{

    // Enhver vare har en pris
    protected double pris;

    // Enhver vare har ogsaa en % merverdiavgift
    private static final double MVA = 0.25; // God praksis å bruke ALL-CAPS på konstanter

    // Initialiserer hver vare med en pris
    public Vare(double pris) {
        this.pris = pris;
    }

    public double beregnFullPris() {
        return pris + pris * MVA;
    }

    public void skrivVare() {
        System.out.println("pris: " + beregnFullPris());
    }
}