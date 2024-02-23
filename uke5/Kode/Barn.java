

class Barn{

    Barn neste;
    String navn; // data

    Barn(String navn){
        this.navn = navn;
    }

    void settNeste(Barn b){
        neste = b;
    }

    String hentNavn(){
        return navn;
    }

}