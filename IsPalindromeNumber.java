import java.util.Date;

class IsPalindromeNumber {
  public static void main(String[] args) {
    Date startDate = new Date();
    testIsPalindrome(121, true);
    testIsPalindrome(-121, false);
    testIsPalindrome(10, false);
    testIsPalindrome(12121, true);

    Date endDate = new Date();
    System.out.println("first result speed: " + String.valueOf(endDate.getTime() - startDate.getTime()));

    startDate = new Date();
    testisPalindromeNumberReverseStr(121, true);
    testisPalindromeNumberReverseStr(-121, false);
    testisPalindromeNumberReverseStr(10, false);
    testisPalindromeNumberReverseStr(12121, true);

    endDate = new Date();
    System.out.println("first result speed: " + String.valueOf(endDate.getTime() - startDate.getTime()));

  }

  public static void testIsPalindrome(int x, boolean expectResult) {
    if (isPalindromeNumber(x) == expectResult) {
      // do nothing
    } else {
      System.out.println("err! input:  " + x + ", expect: " + expectResult);
    }

  }

  public static void testisPalindromeNumberReverseStr(int x, boolean expectResult) {
    if (isPalindromeNumberReverseStr(x) == expectResult) {
      // do nothing
    } else {
      System.out.println("err! input:  " + x + ", expect: " + expectResult);
    }

  }

  public static boolean isPalindromeNumberReverseStr(int x) {
    if (x < 0) {
      return false;
    }

    StringBuilder sb = new StringBuilder();
    sb.append(String.valueOf(x));

    return String.valueOf(x).equals(sb.reverse().toString());

    // String s = String.valueOf(x);
    // int xLength = s.length();

    // for (int i = 0; i < xLength / 2; i++) {
    // if (s.charAt(i) == s.charAt(s.length() - i - 1)) {
    // continue;
    // } else {
    // return false;
    // }
    // }

    // return true;
  }

  public static boolean isPalindromeNumber(int x) {
    if (x < 0) {
      return false;
    }

    String s = String.valueOf(x);
    int xLength = s.length();

    for (int i = 0; i < xLength / 2; i++) {
      if (s.charAt(i) == s.charAt(s.length() - i - 1)) {
        continue;
      } else {
        return false;
      }
    }

    return true;
  }
}