import java.util.Date;
import java.util.Stack;

class IsValidBrackets {
  public static void main(String[] args) {
    Date start = new Date();

    IsValidBrackets app = new IsValidBrackets();
    app.run();

    Date end = new Date();
    System.out.println(end.getTime() - start.getTime() + " ms");
  }

  private void run() {
    equalsTest("", true);
    equalsTest("()", true);
    equalsTest("()[]{}", true);
    equalsTest("(]", false);
    equalsTest("([)]", false);
    equalsTest("{[]}", true);
  }

  public boolean isValid(String s) {
    int length = s.length();
    if (length % 2 != 0) {
      return false;
    }

    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < length; i++) {
      Character c = s.charAt(i);
      if (isLeftPart(c)) {
        stack.push(c);
      } else {
        // no pair for this right part
        if (stack.empty()) {
          return false;
        }

        if (!isCouple(stack.pop(), c)) {
          return false;
        }
      }
    }

    if (stack.empty()) {
      return true;
    }

    return false;
  }

  private boolean isLeftPart(Character c) {
    if (c == '(' || c == '{' || c == '[') {
      return true;
    }

    return false;
  }

  private boolean isCouple(Character pop, Character c) {
    if ((c == ')' && pop == '(') || (c == '}' && pop == '{') || (c == ']' && pop == '[')) {
      return true;
    }
    return false;
  }

  private void equalsTest(String s, boolean expectation) {
    boolean result = isValid(s);
    if (result != expectation) {
      System.out.println("Error! s: " + s + ", isValid expectation is " + expectation);
    }
  }
}