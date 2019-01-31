import java.util.Date;
import java.util.concurrent.Future;

class RomanNumber {
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

  private static String intToRoman(int num) {
    if (num <= 0) {
      return "";
    }
    StringBuilder romanSb = new StringBuilder();

    int[] types = { 1000, 500, 100, 50, 10, 5, 1 };
    int[] outTmp = new int[types.length];
    int restNumber = num;

    for (int i = 0; i < types.length; i++) {
      outTmp[i] = restNumber / types[i];
      restNumber = restNumber % types[i];

      switch (types[i]) {
      case 1:
        appendLetterMultipleTimes(romanSb, "I", outTmp[i]);
        break;
      case 5:
        appendLetterMultipleTimes(romanSb, "V", outTmp[i]);
        break;
      case 10:
        appendLetterMultipleTimes(romanSb, "X", outTmp[i]);
        break;
      case 50:
        appendLetterMultipleTimes(romanSb, "L", outTmp[i]);
        break;
      case 100:
        appendLetterMultipleTimes(romanSb, "C", outTmp[i]);
        break;
      case 500:
        appendLetterMultipleTimes(romanSb, "D", outTmp[i]);
        break;
      case 1000:
        appendLetterMultipleTimes(romanSb, "M", outTmp[i]);
        break;
      default:
        break;
      }
    }

    // System.out.println(romanSb.toString());
    String romanStr = romanSb.toString();

    // romanStr = romanStr.replaceAll("CCCCCCCCC", "CM");
    // romanStr = romanStr.replaceAll("DCCCC", "CM");
    // romanStr = romanStr.replaceAll("CCCC", "CD");
    // romanStr = romanStr.replaceAll("XXXXXXXXX", "XC");
    // romanStr = romanStr.replaceAll("LXXXX", "XC");
    // romanStr = romanStr.replaceAll("XXXX", "XL");
    // romanStr = romanStr.replaceAll("IIIIIIIII", "IX");
    // romanStr = romanStr.replaceAll("VIIII", "IX");
    // romanStr = romanStr.replaceAll("IIII", "IV");

    romanStr = replaceByHand(romanStr, "CCCCCCCCC", "CM");
    romanStr = replaceByHand(romanStr, "DCCCC", "CM");
    romanStr = replaceByHand(romanStr, "CCCC", "CD");
    romanStr = replaceByHand(romanStr, "XXXXXXXXX", "XC");
    romanStr = replaceByHand(romanStr, "LXXXX", "XC");
    romanStr = replaceByHand(romanStr, "XXXX", "XL");
    romanStr = replaceByHand(romanStr, "IIIIIIIII", "IX");
    romanStr = replaceByHand(romanStr, "VIIII", "IX");
    romanStr = replaceByHand(romanStr, "IIII", "IV");

    // for (int i : outTmp) {
    // System.out.println(i);
    // }
    // System.out.println(romanStr);
    return romanStr;

  }

  private static void appendLetterMultipleTimes(StringBuilder sb, String type, int times) {
    for (int i = 0; i < times; i++) {
      sb.append(type);
    }
  }

  private static boolean equalsTest(int num, String str) {
    if (str == null) {
      return false;
    }

    String resultStr = intToRoman(num);

    if (str.equals(resultStr)) {
      return true;
    } else {
      System.out.println("Failed!! num: " + num + ", expect:" + str + ", result: " + resultStr);
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