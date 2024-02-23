public abstract class Matvare extends Vare implements Noekkelhullsmerke{

    // Matvarer har noen ekstra egenskaper
    protected int sunnhetsGrad;
    protected String navn;
    private static final double MVA = 0.14; // Matvare har en egen MVA!

    public Matvare(double pris, int sunnhetsGrad, String navn) {
        super(pris); // Kaller super-konstruktøren
        if (sunnhetsGrad < 1 || sunnhetsGrad > 10) this.sunnhetsGrad = 1; // For lav eller for høy sunnhetsgrad er ikke bra!
        else this.sunnhetsGrad = sunnhetsGrad; 
        this.navn = navn;
    }

    public boolean erNoekkelhullsmerket() {
        return sunnhetsGrad >= 6;
    }

    public String hentNavn() {
        return navn;
    }

    // Hvorfor må vi overskrive beregnFullPris?
    // Hint: Fordi MVA blir re-definert
    @Override
    public double beregnFullPris() {
        return pris + pris * MVA;
    }

    @Override
    public void skrivVare() {
        System.out.println("Navn " + navn);
        System.out.println("sunnhetsgrtad: " + sunnhetsGrad);
        System.out.println("Vare noekkelhullsmerket? " + (erNoekkelhullsmerket() ? "Ja" : "Nei"));
        super.skrivVare(); // Hva skjer her? :)
    }
}
