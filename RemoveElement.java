import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collectors;

class RemoveElement {
  public static void main(String[] args) {
    Date start = new Date();
    RemoveElement app = new RemoveElement();
    app.run();

    Date end = new Date();
    System.out.println("Time: " + (end.getTime() - start.getTime()));
  }

  private void run() {
    int[] l1 = { 3, 2, 2, 3 };
    test(l1, 3, 2);
    int[] l2 = { 0, 1, 2, 2, 3, 0, 4, 2 };
    test(l2, 2, 5);
  }

  public int removeElement(int[] nums, int val) {
    if (nums.length == 0) {
      return 0;
    }

    int left = 0, right = nums.length - 1;

    while (left <= right) {
      while (right > left && nums[right] == val) {
        right--;
      }
      if (nums[left] == val) {
        nums[left] = nums[right];
        right--;
      }
      left++;
    }

    return right + 1;

  }

  private void test(int[] list, int val, int expectation) {
    int result = removeElement(list, val);

    if (result != expectation) {
      System.out.print("result: " + result + ", exp: " + expectation);
      System.out.print(", list: ");
      System.out.println(Arrays.stream(list).mapToObj(i -> String.valueOf(i)).collect(Collectors.joining(", ")));
    }
  }
}