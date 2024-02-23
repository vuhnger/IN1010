import java.util.ArrayList;

interface Enkeltlenket<T>{
    void leggTilBakerst(T e);
    T fjernForste();
    void skrivUt();
    void fyllOpp(ArrayList<T> liste);
}