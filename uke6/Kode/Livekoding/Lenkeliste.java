import java.util.Iterator;
import java.util.NoSuchElementException;

public class Lenkeliste<T> implements Iterable<T> {

  Node forste, siste;

  public Lenkeliste() {

  }

  void settInn(T data) {
    Node nyNode = new Node(data);
    if (forste == null) {
      forste = nyNode;
      siste = nyNode;
    } else {
      nyNode.neste = forste;
      forste.forrige = nyNode;
      forste = nyNode;
    }
  }

  T fjern() {
    if (siste == null) {
      throw new NoSuchElementException("Listen er tom");
    }
    T data = siste.data;
    if (forste == siste) {
      forste = null;
      siste = null;
    } else {
      siste = siste.forrige;
      siste.neste = null;
    }
    return data;
  }

  // Vi skal implementere disse funksjonene!
  void skrivUt() {
    for (T t : this) {
      System.out.print(t + " ");
    }
  }

  class Node {
    T data;
    Node neste, forrige;

    Node(T data) {
      this.data = data;
    }
  }

  // Lage iterator! :D

  

}
