
class Recursion {

    public static void tellNedRek(int n){
      if (n < 0) return;
      System.out.print(" " + n);
      tellNedRek(n - 1);
    }
  
    public static void tellNedIt(int n){
      // Hvordan?
    }
  
    public static int eksponent(int x, int eksponent){
      if (eksponent < 1) return 1;
      return x * eksponent(x, eksponent - 1);
    }
  
    public static void gaa(int steg){
      if (steg < 1) return;
      System.out.println("Jeg går et steg... ");
      gaa(steg - 1);
    }
  
    public static int fib(int n){
      if (n <= 1) return n;
      return fib(n - 1) + fib(n - 2);
    }
  
    public static void main(String[] args) {
  
      //tellNedRek(5);
      //tellNedIt(5);
      //System.out.println(eksponent(2, 2));
      //gaa(5);
      //fib(10);
    }
  
  }
  
  
  
  