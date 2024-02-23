import java.util.ArrayList;

public class Handleliste {

    public static void main(String[] args) {
        ArrayList<Vare> handleliste = new ArrayList<>();

        Godteri sjokolade = new Godteri(40,3,"mork sjokolade");

        Frukt frukt = new Frukt(20,10,"Appelsin");

        handleliste.add(sjokolade);
        handleliste.add(frukt);

        int totalPris = 0;

        for (Vare vare : handleliste) {
            totalPris += vare.beregnFullPris();
            vare.skrivVare();
            System.out.println();

            if (vare instanceof Matvare) {
                Matvare matvare = (Matvare) vare;
                System.out.println(matvare.hentNavn() + (matvare.erNoekkelhullsmerket() ? " er nokkelhullsmerket" : " er ikke nokkelhullsmerket"));   
            }
        }
        System.out.println("totalPris for handleliste er " + totalPris);
    }
    
}
