public class Hovedprogram {
    public static void main(String[] args) {
        
        String[] dummyStrings = new String[]{
            "I", "LOVE", "TO", "CODE", "AND", "IN1010", "IS", "MY", "FAVOTRITE", "COURSE"
        };

        Lenkeliste<String> lenkeliste = new Lenkeliste<String>();

        // Fyll opp beholderen
        for (int i = dummyStrings.length - 1; i > -1; i--){
            lenkeliste.settInn(dummyStrings[i]);
        }

        // Sjekk innholdet ved å iterere gjennom med for-each!!
        lenkeliste.skrivUt();

    }
}
