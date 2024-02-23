import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Hovedprogram {

    // Spør: Kunne vi brukt array her?
    static ArrayList<Barn> lesBarnFil(String filsti){
        ArrayList<Barn> barnListe = new ArrayList<>();
        try(BufferedReader leser = new BufferedReader(new FileReader(filsti))){
            String linje;
            while ((linje = leser.readLine()) != null){
                Barn nyttBarn = new Barn(linje);
                barnListe.add(nyttBarn);
            }
        }catch (IOException e){
            System.out.println(
                "Det oppstod en feil ved innlesing av fil: " + filsti
            + "\nFeilmelding: " + e.getMessage()
            );
        }
        return barnListe;
    }

    public static void main(String[] args) {

        BarneTog smestadBarneTog = new BarneTog();
        ArrayList<Barn> minBarneLste = lesBarnFil("norwegian_child_names.txt");
        smestadBarneTog.fyllOpp(minBarneLste);

        smestadBarneTog.skrivUt();

        smestadBarneTog.hentForste();
        smestadBarneTog.hentSiste();
    
        smestadBarneTog.hentAlleBarn(minBarneLste);
        smestadBarneTog.skrivUt();

    }

}