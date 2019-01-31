import java.util.Arrays;
import java.util.Date;

class LogenstCommonPrefix {
  public static void main(String[] args) {
    Date start = new Date();

    String[] strs = { "flower", "flow", "flight" };
    longestCommonPrefixTest(strs, "fl");
    String[] strs2 = { "dog", "racecar", "car" };
    longestCommonPrefixTest(strs2, "");
    String[] strs3 = { "aca", "cba" };
    longestCommonPrefixTest(strs3, "");

    Date end = new Date();
    System.out.println(end.getTime() - start.getTime() + " ms");

  }

  private static String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0) {
      return "";
    }

    StringBuilder sb = new StringBuilder();
    int[] wordLengths = new int[strs.length];

    for (int i = 0; i < strs.length; i++) {
      wordLengths[i] = strs[i].length();
    }

    Arrays.sort(wordLengths);

    checkPrefixLoop: for (int i = 0; i < wordLengths[0]; i++) {
      char criteriaLetter = strs[0].charAt(i);
      for (int j = 0; j < strs.length; j++) {
        if (strs[j].charAt(i) == criteriaLetter) {
          if (j == strs.length - 1) {
            sb.append(criteriaLetter);
          }
        } else {
          break checkPrefixLoop;
        }
      }
    }

    return sb.toString();

  }

  private static void longestCommonPrefixTest(String[] strs, String expectation) {
    String result = longestCommonPrefix(strs);

    if (expectation.equals(result)) {
      return;
    } else {
      System.out
          .println("Failed!! String[]: " + printArrayStr(strs) + ", expect:" + expectation + ", result: " + result);
    }

  }

  private static void printArray(int arr[]) {
    for (int i : arr) {
      System.out.print(i + " ");
    }
  }

  private static String printArrayStr(String arr[]) {
    StringBuilder sb = new StringBuilder();
    for (String i : arr) {
      sb.append(i);
      sb.append(" ");
    }
    return sb.toString();
  }
}