import java.util.Iterator;

public class Uke<Dag> implements Iterable<Dag>{

    @Override
    public Iterator<Dag> iterator() {
        return new UkeIterator();
    }

    class UkeIterator implements Iterator<Dag>{
        Dag iDag;

        @Override
        public boolean hasNext(){
            return !iDag.equals("søndag");
        }
        @Override
        public Dag next() {
            return iDag;
        }
    }
    
}



