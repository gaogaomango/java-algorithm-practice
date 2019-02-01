import java.util.Date;

class IsValidBrackets {
  public static void main(String[] args) {
    Date start = new Date();

    IsValidBrackets app = new IsValidBrackets();
    app.run();

    Date end = new Date();
    System.out.println(end.getTime() - start.getTime() + " ms");
  }

  private void run() {
    equalsTest("()", true);
    equalsTest("()[]{}", true);
    equalsTest("(]", false);
    equalsTest("([)]", false);
    equalsTest("{[]}", true);
  }

  public boolean isValid(String s) {
    boolean result = false;

    return result;
  }

  private void equalsTest(String s, boolean expectation) {
    boolean result = isValid(s);
    if (result != expectation) {
      System.out.println("Error! s: " + s + ", isValid expectation is " + expectation);
    }
  }
}