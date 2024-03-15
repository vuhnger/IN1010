class Polymorfi{

}

abstract class Kjoretoy {
    int drivstoff;
    abstract void kjor();
}

class Bil extends Kjoretoy{
    @Override
    void kjor(){drivstoff-=10;}
}

class Lastebil extends Kjoretoy{
    @Override
    void kjor(){drivstoff-=50;}
}