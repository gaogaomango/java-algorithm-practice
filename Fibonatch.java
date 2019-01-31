import java.util.Date;

class Fibonatch {
  public static void main(String[] args) {
    Date start = new Date();
    System.out.println(fib(100));
    Date end = new Date();
    System.out.println(end.getTime() - start.getTime() + " ms");
  }

  private static double fib(int n) {
    return n <= 1 ? 1 : fib(n - 1) + fib(n - 2);
  }
}