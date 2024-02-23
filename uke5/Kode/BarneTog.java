import java.util.ArrayList;

public class BarneTog implements Enkeltlenket<Barn>{

    Barn forste, siste;

    BarneTog(){
        
    }

    public void leggTilBakerst(Barn b){
        if (siste == null){
            forste = siste = b;
        }
        siste.settNeste(b);
        siste = b;
    }

    public Barn fjernForste(){
        Barn tmp = forste;
        forste.settNeste(forste.neste);
        return tmp;
    }
    
    public void skrivUt(){

        if (forste == null){
            System.out.println("BarneToget er tomt! :)");
        }

        Barn denne = forste;
        while (denne != null){
            System.out.println(denne.hentNavn());
            denne = denne.neste;
        }
    }

    public void fyllOpp(ArrayList<Barn> barneliste){
        for (Barn b : barneliste){
            leggTilBakerst(b);
        }
    }

    void hentForste(){System.out.println("Forste barn: " + forste.hentNavn());}

    void hentSiste(){System.out.println("Siste barn: " + siste.hentNavn());}
}