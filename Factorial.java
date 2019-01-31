import java.util.Date;

class Factorial {
  public static void main(String[] args) {
    Date start = new Date();
    System.out.println(factorial(10));
    Date end = new Date();
    System.out.println(end.getTime() - start.getTime() + " ms");
  }

  private static double factorial(double n) {
    return n == 0 ? 1 : n * factorial(n - 1);
  }
}