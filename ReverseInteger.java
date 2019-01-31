import java.util.Date;

class ReverseInteger {
  public static void main(String[] args) {
    Date start = new Date();

    System.out.println(reverse(123));
    System.out.println(reverse(-123));
    System.out.println(reverse(120));
    System.out.println(reverse(1534236469));

    Date end = new Date();
    System.out.println(end.getTime() - start.getTime() + " ms");
  }

  private static int reverse(int x) {
    int rev = 0;
    while (x != 0) {
      int pop = x % 10;
      x /= 10;
      if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7))
        return 0;
      if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8))
        return 0;
      rev = rev * 10 + pop;
    }

    return rev;
  }

  // toString
  // private static int reverse(int x) {
  // String xStr = String.valueOf(Math.abs(x));
  // StringBuilder sb = new StringBuilder();
  // if (x < 0) {
  // sb.append("-");
  // }
  // for (int i = xStr.length() - 1; i >= 0; i--) {
  // sb.append(xStr.charAt(i));
  // }
  // System.out.println(sb.toString());
  // try {
  // return Integer.parseInt(sb.toString());
  // } catch (NumberFormatException e) {
  // return 0;
  // }
  // }

}