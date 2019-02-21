import java.util.Date;

class CountAndSay {
  public static void main(String[] args) {
    Date start = new Date();
    CountAndSay app = new CountAndSay();
    app.run();

    System.out.println("Time: " + (new Date().getTime() - start.getTime()));
  }

  public String countAndSay(int n) {
    int rest = n;
    int fiveCount = rest / 5;
    rest -= fiveCount * 5;
    int fourCount = rest / 4;
    rest -= fourCount * 4;
    int threeCount = rest / 3;
    rest -= threeCount * 3;
    int twoCount = rest / 2;
    rest -= twoCount * 2;
    int oneCount = rest;

    StringBuilder sb = new StringBuilder();
    appendCountStr(sb, fiveCount, 5);
    appendCountStr(sb, fourCount, 4);
    appendCountStr(sb, threeCount, 3);
    appendCountStr(sb, twoCount, 2);
    appendCountStr(sb, oneCount, 1);

    return sb.toString();
  }

  private void appendCountStr(StringBuilder sb, int count, int countNumber) {
    if (count != 0) {
      sb.append(getNumberStr(countNumber));
    }
  }

  private String getNumberStr(int countType) {
    switch (countType) {
    case 1:
      return "1";
    case 2:
      return "11";
    case 3:
      return "21";
    case 4:
      return "1211";
    case 5:
      return "111221";
    default:
      return "";
    }
  }

  private void run() {
    test(1, "1");
    test(2, "11");
    test(3, "21");
    test(4, "1211");
    test(5, "111221");
    test(6, "312211");
  }

  private void test(int n, String exp) {
    String result = countAndSay(n);
    if (!exp.equals(result)) {
      System.out.println("Error! input: " + n + ", result: " + result + ", exp: " + exp);
    }
  }
}