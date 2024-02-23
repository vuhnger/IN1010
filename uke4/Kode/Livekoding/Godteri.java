package Livekoding;

public class Godteri extends MatVare{

    private int phVerdi;
    private static final double MVA = 0.2;

    public Godteri(double pris, int sunnhetsGrad, String navn, int phVerdi){
        super(pris, sunnhetsGrad, navn);
        this.phVerdi = phVerdi;
    }

    @Override
    public boolean erNoekkelhullsMerket(){
        return sunnhetsGrad >= 9 && phVerdi > 10;
    }

    @Override
    public double beregnFullPris(){
        return pris + (pris * MVA);
    }

    @Override
    public void skrivVare(){
        super.skrivVare();
        System.out.println("PhVerdi på godteri: " + phVerdi);
    }

}