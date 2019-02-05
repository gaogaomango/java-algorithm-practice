import java.util.Date;

class DivideTwoIntegers {
  public static void main(String[] args) {
    Date start = new Date();
    DivideTwoIntegers app = new DivideTwoIntegers();
    app.run();

    Date end = new Date();
    System.out.println("Time: " + (end.getTime() - start.getTime()));
  }

  private void run() {
    test(10, 3, 3);
    test(7, -3, -2);
    test(-2147483648, -1, 2147483647);
    test(2147483647, 2, 1073741823);
    test(-2147483648, 2, -1073741824);
  }

  public int divide(int dividend, int divisor) {
    if (divisor == 1) {
      return dividend;
    }

    if (dividend > 0) {
      return -divide(-dividend, divisor);
    } else if (divisor > 0) {
      return -divide(dividend, -divisor);
    }

    if (dividend > divisor) {
      return 0;
    }

    if ((dividend == Integer.MIN_VALUE) && (divisor == -1)) {
      return Integer.MAX_VALUE;
    }

    int min_divisor = Integer.MIN_VALUE >> 1;
    int mult = divisor;
    int shifts = 0;
    while ((mult >= min_divisor) && (mult > dividend)) {
      mult <<= 1;
      ++shifts;
    }

    int result = 0;
    int power = 1 << shifts;
    while (dividend <= divisor) {
      shifts = 0;
      while (mult < dividend) {
        mult >>= 1;
        ++shifts;
      }
      dividend -= mult;
      power >>= shifts;
      result |= power;
    }

    return result;
  }

  private void test(int dividend, int divisor, int expectation) {
    int result = divide(dividend, divisor);

    if (result != expectation) {
      System.out.print("result: " + result + ", exp: " + expectation);
      System.out.println(", dividend: " + dividend + ", divisor: " + divisor);
    }
  }

}