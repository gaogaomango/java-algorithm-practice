import java.util.Date;

class RomanToInteger {
  public static void main(String[] args) {
    Date start = new Date();

    equalsTest(3, "III");
    equalsTest(4, "IV");
    equalsTest(9, "IX");
    equalsTest(58, "LVIII");
    equalsTest(1994, "MCMXCIV");

    Date end = new Date();
    System.out.println(end.getTime() - start.getTime() + " ms");
  }

  private static int romanToInt(String s) {
    if (s == null) {
      return 0;
    }
    int result = 0;

    s = replaceByHand(s, "CM", "CCCCCCCCC");
    s = replaceByHand(s, "CM", "DCCCC");
    s = replaceByHand(s, "CD", "CCCC");
    s = replaceByHand(s, "XC", "XXXXXXXXX");
    s = replaceByHand(s, "XC", "LXXXX");
    s = replaceByHand(s, "XL", "XXXX");
    s = replaceByHand(s, "IX", "IIIIIIIII");
    s = replaceByHand(s, "IX", "VIIII");
    s = replaceByHand(s, "IV", "IIII");

    char[] cArray = s.toCharArray();

    for (char c : cArray) {
      switch (c) {
      case 'I':
        result += 1;
        break;
      case 'V':
        result += 5;
        break;
      case 'X':
        result += 10;
        break;
      case 'L':
        result += 50;
        break;
      case 'C':
        result += 100;
        break;
      case 'D':
        result += 500;
        break;
      case 'M':
        result += 1000;
        break;
      default:
        break;
      }
    }

    return result;
  }

  private static void appendLetterMultipleTimes(StringBuilder sb, String type, int times) {
    for (int i = 0; i < times; i++) {
      sb.append(type);
    }
  }

  private static boolean equalsTest(int expect, String s) {
    if (s == null) {
      return false;
    }

    int result = romanToInt(s);

    if (expect == result) {
      return true;
    } else {
      System.out.println("Failed!! roman: " + s + ", expect:" + expect + ", result: " + result);
      return false;
    }
  }

  private static String replaceByHand(final String original, final String old, final String replace) {
    int offset = 0;
    StringBuilder builder = new StringBuilder(original.length());
    int index;
    while (0 <= (index = original.indexOf(old, offset))) {
      builder.append(original, offset, index);
      builder.append(replace);
      offset = index + old.length();
    }
    builder.append(original, offset, original.length());
    return builder.toString();
  }
}