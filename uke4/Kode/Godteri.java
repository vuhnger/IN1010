public class Godteri extends Matvare {

    private int phVerdi; // Godteri har en Ph-verdi
    private static final double MVA = 0.2; // Og en egen MVA

    // Konstruktøralternativ 1
    public Godteri(double pris, int sunnhetsGrad, String navn, int ph) {
        super(pris, sunnhetsGrad, navn);
        phVerdi = ph;
    }
    
    // Konstruktøralternativ 2
    // Å tilby flere alternative konstruktører kalles Overloading
    public Godteri(double pris, int sunnhetsGrad, String navn) {
        // Hvis det ikke oppgis noen ph-verdi, settes den til -1.
        this(pris, sunnhetsGrad, navn, -1);
    }

    // Godteri har egne krav for å få nøkkelhullsmerke!
    @Override
    public boolean erNoekkelhullsmerket() {
        return sunnhetsGrad >= 9 && phVerdi > 10;
    }

    @Override
    public double beregnFullPris() {
        return pris + pris * MVA;
    }

    @Override
    public void skrivVare() {
        super.skrivVare();
        System.out.println("Ph-verdi: " + phVerdi);
    }

}
