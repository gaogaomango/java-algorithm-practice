import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

class LongestPalindrome {
  public static void main(String[] args) {

    String s = "abacb";
    System.out.println(longestPalindrome(s));
    String c = "ccc";
    System.out.println(longestPalindrome(c));
    String d = "abcdedcba";
    System.out.println(longestPalindrome(d));
    String e = "abcda";
    System.out.println(longestPalindrome(e));
    String f = "cbbd";
    System.out.println(longestPalindrome(f));
    // String g =
    // "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
    // System.out.println(longestPalindrome(g));
    // String h =
    // "321012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210123210012321001232100123210123";
    // System.out.println(longestPalindrome(h));
  }

  // manacer by myself
  private static String longestPalindrome(String s) {

    if (s == null || s.length() == 0) {
      return "";
    }

    char[] charArray = addBoundaries(s.toCharArray());

    int[] lengths = new int[charArray.length];
    int radius = 0;
    int leftPosion = 0, rightPostion = 0;
    int mirror = 0;

    for (int i = 1; i < charArray.length; i++) {
      if (i > radius) {
        lengths[i] = 0;
        leftPosion = i - 1;
        rightPostion = i + 1;
      } else {
        int i2 = mirror * 2 - i; // ★★★★★★??????????
        if (lengths[i2] < (radius - i - 1)) {
          lengths[i] = lengths[i2];
          leftPosion = -1; // ★★★★★★??????????
        } else {
          lengths[i] = radius - i;
          rightPostion = radius + 1;
          leftPosion = i * 2 - rightPostion;
        }
      }
      while (leftPosion >= 0 && rightPostion < charArray.length && charArray[leftPosion] == charArray[rightPostion]) {
        lengths[i]++;
        leftPosion--;
        rightPostion++;
      }

      // ???
      if ((i + lengths[i]) > radius) {
        mirror = i;
        radius = i + lengths[i];
      }
    }

    int len = 0;
    mirror = 0;
    System.out.println("長さの集計出力");
    for (int i = 1; i < charArray.length; i++) {
      System.out.print(lengths[i]);
      if (len < lengths[i]) {
        len = lengths[i];
        mirror = i;
      }
    }
    System.out.println("");

    char[] chars = Arrays.copyOfRange(charArray, mirror - len, mirror + len + 1);
    System.out.println("最終出力する前の配列");
    for (char c : chars) {
      System.out.print(c);
    }
    System.out.println("");

    return String.valueOf(removeBoundaries(chars));

  }

  private static char[] addBoundaries(char[] strCharArr) {
    if (strCharArr == null || strCharArr.length == 0) {
      return "||".toCharArray();
    }
    char boundary = '|';
    char[] charArr = new char[2 * strCharArr.length + 1];

    for (int i = 0; i < charArr.length - 2; i = i + 2) {
      charArr[i] = boundary;
      charArr[i + 1] = strCharArr[i / 2];
    }
    charArr[charArr.length - 1] = boundary;
    System.out.println("|を追加した配列");
    for (char c : charArr) {
      System.out.print(c);
    }
    System.out.println("");
    return charArr;
  }

  private static char[] removeBoundaries(char[] strCharArr) {
    if (strCharArr == null || strCharArr.length == 0) {
      return "".toCharArray();
    }
    char[] charArr = new char[(strCharArr.length - 1) / 2];
    for (int i = 0; i < charArr.length; i++) {
      charArr[i] = strCharArr[(i * 2) + 1];
    }
    return charArr;
  }

  // manacer
  // private static String longestPalindrome(String s) {
  // if (s == null || s.length() == 0)
  // return "";

  // char[] s2 = addBoundaries(s.toCharArray());
  // int[] p = new int[s2.length];
  // int c = 0, r = 0; // Here the first element in s2 has been processed.
  // int m = 0, n = 0; // The walking indices to compare if two elements are the
  // same
  // for (int i = 1; i < s2.length; i++) {
  // if (i > r) {
  // p[i] = 0;
  // m = i - 1;
  // n = i + 1;
  // } else {
  // int i2 = c * 2 - i;
  // if (p[i2] < (r - i - 1)) {
  // p[i] = p[i2];
  // m = -1; // This signals bypassing the while loop below.
  // } else {
  // p[i] = r - i;
  // n = r + 1;
  // m = i * 2 - n;
  // }
  // }
  // while (m >= 0 && n < s2.length && s2[m] == s2[n]) {
  // p[i]++;
  // m--;
  // n++;
  // }
  // if ((i + p[i]) > r) {
  // c = i;
  // r = i + p[i];
  // }
  // }
  // int len = 0;
  // c = 0;
  // for (int i = 1; i < s2.length; i++) {
  // if (len < p[i]) {
  // len = p[i];
  // c = i;
  // }
  // }
  // char[] ss = Arrays.copyOfRange(s2, c - len, c + len + 1);
  // return String.valueOf(removeBoundaries(ss));
  // }

  // private static char[] addBoundaries(char[] cs) {
  // if (cs == null || cs.length == 0)
  // return "||".toCharArray();

  // char[] cs2 = new char[cs.length * 2 + 1];
  // for (int i = 0; i < (cs2.length - 1); i = i + 2) {
  // cs2[i] = '|';
  // cs2[i + 1] = cs[i / 2];
  // }
  // cs2[cs2.length - 1] = '|';
  // return cs2;
  // }

  // private static char[] removeBoundaries(char[] cs) {
  // if (cs == null || cs.length < 3)
  // return "".toCharArray();

  // char[] cs2 = new char[(cs.length - 1) / 2];
  // for (int i = 0; i < cs2.length; i++) {
  // cs2[i] = cs[i * 2 + 1];
  // }
  // return cs2;
  // }

  /** Calc O^3 */
  // private static String longestPalindrome(String s) {
  // Date startDate = new Date();
  // String maxString = "";

  // int strLength = s.length();

  // int centerIndex = (int) Math.floor(strLength / 2.0);

  // for (int i = 0; i < centerIndex + 1; i++) {
  // String tmpStr = getLongenstPalindrome(s, i, j);
  // if (tmpStr != null) {
  // maxString = maxString.length() < tmpStr.length() ? tmpStr : maxString;
  // }
  // }
  // if (maxString == null || maxString.isEmpty()) {
  // maxString = s;
  // }

  // Date endDate = new Date();
  // System.out.println("time: " + (endDate.getTime() - startDate.getTime()));

  // return maxString;
  // }

}