import java.util.ArrayList;

interface Enkeltlenket<T>{
    void leggTilBakerst(T e);
    T fjern(String id);
    void skrivUt();
    void fyllOpp(ArrayList<T> liste);
}