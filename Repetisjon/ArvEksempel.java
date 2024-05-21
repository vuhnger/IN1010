import java.util.ArrayList;

interface Alarm {
    void aktiverAlarm();
}

abstract class Kjoretoy {
    static int antallKjoretoy = 0;
    int hastighet;
    protected String merke, reg;

    Kjoretoy(String merke, String reg, int hasighet) {
        this.merke = merke;
        this.reg = reg;
        this.hastighet = hasighet;
        antallKjoretoy++;
    }

    void kjor(int tid) {
        System.out.println(reg + " kjorte " + (tid * hastighet) + " km");
    }
}

class Bil extends Kjoretoy implements Alarm {

    Bil(String merke, String reg) {
        super(merke, reg, 50);
    }

    @Override
    void kjor(int tid) {
        System.out.print("Bil ");
        super.kjor(tid);
    }

    @Override
    public void aktiverAlarm() {
        System.out.println("Alarmen til " + reg + " aktivert!");
    }
}

class Motorsykkel extends Kjoretoy {

    Motorsykkel(String merke, String reg) {
        super(merke, reg, 80);
    }

    @Override
    void kjor(int tid){
        System.out.print("Motorsykkel ");
        super.kjor(tid);
    }

    void wheelie() {
        System.out.println(reg + " fyrer opp en wheelie!");
    }
}

class Garasje {
    private ArrayList<Kjoretoy> kjoretoy = new ArrayList<>();

    Garasje(Kjoretoy... samling) {
        for (Kjoretoy k : samling) {
            kjoretoy.add(k);
        }
    }

    void parker(Kjoretoy k) {
        kjoretoy.add(k);
    }

    ArrayList<Kjoretoy> hentKjoretoy(){
        return kjoretoy;
    }
}

public class ArvEksempel {
    public static void main(String[] args) {
        Garasje g = new Garasje(
                new Bil("AUDI", "AV212"),
                new Motorsykkel("TOYOTA", "DE899")
                );

        for (Kjoretoy k : g.hentKjoretoy()){

            k.kjor(50);
            
            if (k instanceof Motorsykkel){
                ((Motorsykkel) k).wheelie();
            }

            if (k instanceof Alarm){
                ((Alarm) k).aktiverAlarm();
            }
        }

        System.out.println("Antall kjoretoy som eksisterer: " + Kjoretoy.antallKjoretoy);
    }
}



