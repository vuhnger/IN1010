import java.util.ArrayList;

interface Alarm {
    void aktiverAlarm();
}

abstract class Kjoeretoey {
    static int antallKjoeretoey = 0;

    protected String merke, reg;

    Kjoeretoey(String merke, String reg) {
        this.merke = merke;
        this.reg = reg;
        antallKjoeretoey++;
    }

    void kjoer() {
        System.out.println("Et kjoeretoey kjoerer!");
    }
}

class Bil extends Kjoeretoey implements Alarm {

    Bil(String merke, String reg) {
        super(merke, reg);
    }

    @Override
    void kjoer() {
        System.out.println("Bil " + reg + " kjoerer!");
    }

    @Override
    public void aktiverAlarm() {
        System.out.println("Alarmen til " + reg + " aktivert!");
    }
}

class Motorsykkel extends Kjoeretoey {

    Motorsykkel(String merke, String reg) {
        super(merke, reg);
    }

    @Override
    void kjoer(){
        System.out.println("Motorsykkel " + reg + " kjorer!");
    }

    void wheelie() {
        System.out.println(reg + " fyrer opp en wheelie!");
    }
}

class Garasje {
    private ArrayList<Kjoeretoey> kjoeretoey = new ArrayList<>();

    Garasje(Kjoeretoey... samling) {
        for (Kjoeretoey k : samling) {
            kjoeretoey.add(k);
        }
    }

    void settInn(Kjoeretoey k) {
        kjoeretoey.add(k);
    }

    ArrayList<Kjoeretoey> hentKjoeretoey(){
        return kjoeretoey;
    }
}

public class ArvEksempel {
    public static void main(String[] args) {
        Garasje g = new Garasje(
                new Bil("AUDI", "AV212"),
                new Motorsykkel("TOYOTA", "DE899")
                );

        for (Kjoeretoey k : g.hentKjoeretoey()){

            k.kjoer();
            
            if (k instanceof Motorsykkel){
                ((Motorsykkel) k).wheelie();
            }

            if (k instanceof Alarm){
                ((Alarm) k).aktiverAlarm();
            }
        }

        System.out.println("Antall kjoretoy som eksisterer: " + Kjoeretoey.antallKjoeretoey);
    }
}
