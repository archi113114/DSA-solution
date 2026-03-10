public class Main {
  
//  Question --1
    public static boolean isPrime(int n) {
      if (n <= 1)
         return false;
      for (int i = 2; i < n; i++) {
        if (n % i == 0)
             return false;
      }
      return true;
    }

    public static void Triplets(int limit){
        for (int a = 1; a < limit; a++) {
            for (int b = a; b < limit; b++) {
                int c = (int) Math.sqrt(a * a + b * b);
                if (c < limit && a * a + b * b == c * c) {
                    System.out.println(a + " " + b + " " + c);
                }
            }
        }
    }
    public static void main(String[] args) {
        int n = 29;
        System.out.println(isPrime(n));
        Triplets(20);
    }
}
System.out.println("hello");

