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

    public Barn fjern(String navn){

        if (forste.hentNavn().equals(navn)){
            Barn tmp = forste;
            forste = forste.neste;
            return tmp;
        }
    
        // Iterer over barna til du finner barnet
        Barn denne = forste;
        while(denne.neste != null){
            
            if (denne.hentNavn().equals(navn)){
                hjelpeFjern(denne);
                return denne;
            }
            denne = denne.neste;
        }
        System.out.println("Fant ikke " + navn + " i barneToget.");
        return null;
    }


    void hjelpeFjern(Barn b){
        b.settNeste(b.neste.neste);
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

    public void hentAlleBarn(ArrayList<Barn> barneliste){
        for (Barn b : barneliste){
            fjern(b.hentNavn());
        }
    }

    void hentForste(){System.out.println("Forste barn: " + forste.hentNavn());}

    void hentSiste(){System.out.println("Siste barn: " + siste.hentNavn());}
}