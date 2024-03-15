import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Hash {

    static HashMap<String, Integer> tellNavn(String filnavn) throws IOException{
        HashMap<String, Integer> navneTabell = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(filnavn));
        String navn;
        while ((navn = reader.readLine()) != null){
            if (!navneTabell.containsKey(navn)){
                navneTabell.put(navn, Integer.valueOf(1)); // Oppretter en kolonne med "navn" og verdi 1
            }else{
                navneTabell.put(navn, navneTabell.get(navn) + 1); // Henter frekvensen og legger på 1
            }
        }
        return navneTabell;
    }

    static void skrivUtNavn(HashMap<String, Integer> tabell){
        for (String navn : tabell.keySet()){
            System.out.println(navn + ":" + tabell.get(navn));
        }
    }

    public static void main(String[] args) {
        try {
            HashMap<String, Integer> tabellen = tellNavn("ordfil.txt");
            HashMap<String, Integer> finnesIkke = tellNavn("finnesikke.txt");
            HashMap<String, Integer> IOFeil = tellNavn("falskFil.pdf");
            skrivUtNavn(tabellen);
        }catch (IOException ioe){ // FileNotFoundException arver fra IOException
            if (ioe instanceof FileNotFoundException) System.out.println("Fant ikke filen!");
            else System.out.println("Klarte ikke å lese filen!");
        }
    }

}
