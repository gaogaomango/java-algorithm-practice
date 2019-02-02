import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

class GenerateParentheses {
  public static void main(String[] args) {
    Date start = new Date();

    GenerateParentheses app = new GenerateParentheses();
    app.run();

    Date end = new Date();
    System.out.println(end.getTime() - start.getTime() + " ms");
  }

  private void run() {
    List<String> list1 = Arrays.asList("((()))", "(()())", "(())()", "()(())", "()()()");
    equalsTest(1, 3, list1);
  }

  public List<String> generateParenthesis(int n) {
    if (n < 1) {
      return new ArrayList<>(n);
    }
    List<String> list = new ArrayList<>();
    char[] str = new char[n * 2];
    helper(n, n, str, 0, list);
    return list;
  }

  private void helper(int left, int right, char[] str, int i, List<String> list) {
    if (left < 0 || right < left) {
      return;
    }

    if (left == 0 && right == 0) {
      list.add(String.copyValueOf(str));
    } else {
      str[i] = '(';
      helper(left - 1, right, str, i + 1, list);
      str[i] = ')';
      helper(left, right - 1, str, i + 1, list);
    }
  }

  private void equalsTest(int id, int n, List<String> expectation) {
    // ListNode resultListNode = mergeTwoSortedLists(l1, l2);
    List<String> resultListNode = generateParenthesis(n);
    if (resultListNode.size() != expectation.size()) {
      System.out.println("Error: id " + id + ", size is different from expectation");
    }
    for (int i = 0; i < resultListNode.size(); i++) {
      if (!resultListNode.get(i).equals(expectation.get(i))) {
        System.out.println("Error: id " + id + ", result: " + resultListNode.stream().collect(Collectors.joining(", "))
            + ", expectation: " + expectation.stream().collect(Collectors.joining(", ")));
        break;
      }
    }

  }
}