import java.util.HashMap;
import java.util.Map;

class ZigZagConversion {
  public static void main(String[] args) {
    System.out.println(zigZagConvert("PAYPALISHIRING", 3));

  }

  public static String zigZagConvert(String s, int numRows) {
    if (numRows <= 1) {
      return s;
    }
    StringBuilder sb = new StringBuilder();

    int strLength = s.length();

    int step = 2 * (numRows - 1);

    for (int i = 0; i < numRows; i++) {
      // first
      if (i == 0 || i == numRows - 1) {
        for (int j = i; j < strLength; j = j + step) {
          sb.append(s.charAt(j));
        }
      } else {
        int j = i;
        boolean flag = true;
        int step1 = 2 * (numRows - 1 - i);
        int step2 = 2 * i;

        while (j < strLength) {
          sb.append(s.charAt(j));
          j = flag ? j + step1 : j + step2;
          flag = !flag;
        }
      }
    }

    return sb.toString();
  }
}