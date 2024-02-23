public class Frukt extends Matvare {

    public Frukt(double pris, int sunnhetsGrad, String navn) {
        super(pris, sunnhetsGrad, navn);
    }

    // Alle frukter er nøkkelhullsmerket!!
    @Override
    public boolean erNoekkelhullsmerket() {
        return true;
    }

    // Men ingen frukt har MVA! Vi betaler kun prisen på frukten! :)
    @Override
    public double beregnFullPris() {
        return pris;
    }

    
}
