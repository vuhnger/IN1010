import java.util.ArrayList; 
import java.util.Iterator; 
import java.util.List;

public class IteratorExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(); // Bruker interfacet som referansetype :)
        list.add("One");
        list.add("Two");
        list.add("Three");

        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()) { // hasNext() sjekker om iteratoren kan bevege seg videre
            System.out.println(iterator.next()); // next() henter neste element i samlingen
        }
    }
}
