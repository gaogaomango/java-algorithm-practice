import java.util.Date;

class ImplementStrStr {
  public static void main(String[] args) {
    Date start = new Date();
    ImplementStrStr app = new ImplementStrStr();
    app.run();

    Date end = new Date();
    System.out.println("Time: " + (end.getTime() - start.getTime()));
  }

  private void run() {
    test("hello", "ll", 2);
    test("aaaaa", "bba", -1);
  }

  public int strStr(String haystack, String needle) {
    if (needle == null || "".equals(needle)) {
      return 0;
    }
    if (haystack == null || "".equals(haystack)) {
      return -1;
    }

    int lenStack = haystack.length();
    int lenNeedle = needle.length();

    if (lenStack < lenNeedle) {
      return -1;
    }

    int threshold = lenStack - lenNeedle;
    for (int i = 0; i <= threshold; i++) {
      if (haystack.substring(i, i + lenNeedle).equals(needle)) {
        return i;
      }
    }
    return -1;

    // for (int i = 0;; i++) {
    // for (int j = 0;; j++) {
    // if (j == needle.length())
    // return i;
    // if (i + j == haystack.length())
    // return -1;
    // if (needle.charAt(j) != haystack.charAt(i + j))
    // break;
    // }
    // }
  }

  // public int strStr(String haystack, String needle) {
  // if (needle == null || "".equals(needle)) {
  // return 0;
  // }
  // if (haystack == null || "".equals(haystack)) {
  // return -1;
  // }

  // return haystack.indexOf(needle);
  // }

  private void test(String haystack, String needle, int expectation) {
    int result = strStr(haystack, needle);

    if (result != expectation) {
      System.out.print("result: " + result + ", exp: " + expectation);
      System.out.println(", haystack: " + haystack + ", needle: " + needle);
    }
  }
}