

public class Rekursjon {

    static void tellNed(int n){
        if (n <= 0) return;
        System.out.println("tellned("+n+")");
        tellNed(n - 1);
    }

    public static void main(String[] args) {
        tellNed(5);         
    }
}




