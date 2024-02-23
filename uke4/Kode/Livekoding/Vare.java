package Livekoding;


public abstract class Vare{

    // private -> synlig kun innenfor klassen (Vare)
    // protected -> "package private" synlig innenfor pakke og subklasser
    // public -> synlige overalt

    // Enhver vare har en pris
    protected double pris;

    private static final double MVA = 0.25;

    // Hver vare starter med en pris
    public Vare(double pris){
        this.pris = pris;
    }

    // Beregn full pris
    public double beregnFullPris(){
        return pris + (pris * MVA);
    }

    public void skrivVare(){
        System.out.println("Pris: " + beregnFullPris());
    }

}