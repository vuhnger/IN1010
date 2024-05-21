import java.util.ArrayList;

interface Alarm{
    void aktiverAlarm();
}

abstract class Kjoretoy{
    static int antall = 0;
    int hastighet;

    protected String merke, registrering;

    Kjoretoy(
        String merke,
        String registrering,
        int hastighet
    ){
        this.merke = merke;
        this.registrering = registrering;
        this.hastighet = hastighet;
        antall++;
    }

    void kjor(int tid){
        System.out.println(registrering + " har kjort " + (tid * hastighet) + " km");
    }

}

class Bil extends Kjoretoy implements Alarm{

    Bil(String merke, String registering){
        super(merke, registering, 50);
    }

    @Override
    void kjor(int tid){
        System.out.print("Bil: ");
        super.kjor(tid);
    }

    @Override
    public void aktiverAlarm(){
        System.out.println(registrering + " sin alarm går!");
    }
}

class Motorsykkel extends Kjoretoy{

    Motorsykkel(String merke, String registering){
        super(merke, registering, 100);
    }

    @Override
    void kjor(int tid){
        System.out.print("Motorsykkel: ");
        super.kjor(tid);
    }
    
    void wheelie(){
        System.out.println(registrering + " tar en wheelie!");
    }
}

class Garasje{

    private ArrayList<Kjoretoy> k = new ArrayList<>();

    Garasje(Kjoretoy... samling){
        for (Kjoretoy kjor : samling){
            k.add(kjor);
        }
    }

    ArrayList<Kjoretoy> hentKjoretoy(){
        return k;
    }

    Motorsykkel[] hentSykler(){
        int antallSykler = 0;
        for (Kjoretoy kjor : k){
            if (kjor instanceof Motorsykkel){
                antallSykler++;
            }
        }

        Motorsykkel[] syklene = new Motorsykkel[antallSykler];

        int i = 0;
        for (Kjoretoy kjor : k){
            if (kjor instanceof Motorsykkel){
                syklene[i] = (Motorsykkel) kjor;
                i++;
            }
        }
        return syklene;
    }

}

class Arv{
    public static void main(String[] args){

        Garasje g = new Garasje(
            new Bil("Volvo", "VO899"),
            new Motorsykkel("Toyota", "MO123"),
            new Motorsykkel("BMW", "BM240")
        );

        for (Kjoretoy k : g.hentKjoretoy()){

            k.kjor(10);

            if (k instanceof Motorsykkel){
                ((Motorsykkel) k).wheelie();
            }

            if (k instanceof Alarm){
                ((Alarm) k).aktiverAlarm();
            }

            if (k instanceof Bil){
                System.out.println(((Bil) k).merke);
            }
        }

        Motorsykkel[] syklene = g.hentSykler();

        for (Motorsykkel s : syklene){
            s.wheelie();
        }
    }
}

