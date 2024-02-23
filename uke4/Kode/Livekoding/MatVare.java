package Livekoding;

public abstract class MatVare extends Vare implements NoekkelhullsMerket{

    private static final double MVA = 0.14; // Matvarer har en egen MVA!
    protected int sunnhetsGrad;
    protected String navn;
    
    public MatVare(double pris, int sunnhetsGrad, String navn){
        super(pris);
        if (sunnhetsGrad < 1 || sunnhetsGrad > 10) this.sunnhetsGrad = 1;
        else this.sunnhetsGrad = sunnhetsGrad;
        this.navn = navn;
    }

    // Matvarer med en sunnhetsgrad på over 6 er nøkkelhullsmerket
    @Override
    public boolean erNoekkelhullsMerket(){
        return sunnhetsGrad >= 6;
    }

    public String hentNavn(){
        return navn;
    }

    @Override
    public double beregnFullPris(){
        return pris + (pris * MVA);
    }

    @Override
    public void skrivVare(){
        System.out.println("Navn på vare: " + navn);
        System.out.println("Sunnhetsgrad: " + sunnhetsGrad);
        System.out.println("Vare er nøkkelhullsmerket: " + (erNoekkelhullsMerket() ? "Ja :)" : "Nei :("));
        super.skrivVare();
    }


}