import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collectors;

class RemoveDuplicates {
  public static void main(String[] args) {
    Date start = new Date();
    RemoveDuplicates app = new RemoveDuplicates();
    app.run();

    Date end = new Date();
    System.out.println("Time: " + (end.getTime() - start.getTime()));
  }

  private void run() {
    int[] l1 = { 1, 1, 2 };
    test(l1, 2);
    int[] l2 = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
    test(l2, 5);
  }

  public int removeDuplicates(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    Integer beforeVal = null;
    int i = 0;
    for (int n : nums) {
      if (beforeVal == null || beforeVal.intValue() != n) {
        i++;
        beforeVal = n;
      }
    }

    return i;
  }

  private void test(int[] list, int expectation) {
    int result = removeDuplicates(list);

    if (result != expectation) {
      System.out.print("result: " + result + ", exp: " + expectation);
      System.out.print(", list: ");
      System.out.println(Arrays.stream(list).mapToObj(i -> String.valueOf(i)).collect(Collectors.joining(", ")));
    }
  }
}