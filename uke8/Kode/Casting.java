
class Dyr{}

class Hund extends Dyr{}

public class Casting {
    public static void main(String[] args) {
        Dyr dyr = new Dyr();
        Hund hund = new Hund();
        Hund h = (Hund) dyr; // Caste "oppover"
        Dyr d = (Dyr) hund; // Ikke lov!
    }
}


