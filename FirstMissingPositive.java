import java.util.Arrays;
import java.util.Date;

class FirstMissingPositive {
  public static void main(String[] args) {
    Date start = new Date();
    FirstMissingPositive app = new FirstMissingPositive();
    app.run();

    System.out.println("Time: " + (new Date().getTime() - start.getTime()));
  }

  public int firstMissingPositive(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 1;
    }
    if (nums.length == 1 && (nums[0] > 1 || nums[0] < 1)) {
      return 1;
    }
    Arrays.sort(nums);
    int j = 1;
    int i = 0;
    boolean hasPositive = false;
    int length = removeDuplicates(nums, nums.length);
    for (; i < length; i++) {
      int tmp = nums[i];
      if (tmp <= 0) {
        continue;
      }
      hasPositive = true;

      if (tmp != j) {
        return j;
      }
      j++;
    }

    return j;
  }

  private int removeDuplicates(int[] arr, int n) {
    if (n == 0 || n == 1) {
      return n;
    }
    int j = 0;// for next element
    for (int i = 0; i < n - 1; i++) {
      if (arr[i] != arr[i + 1]) {
        arr[j++] = arr[i];
      }
    }
    arr[j++] = arr[n - 1];
    return j;
  }

  private void run() {
    test(1, new int[] { 1, 2, 0 }, 3);
    test(2, new int[] { 3, 4, -1, 1 }, 2);
    test(3, new int[] { 7, 8, 9, 11, 12 }, 1);
    test(4, new int[] {}, 1);
    test(5, new int[] { 0 }, 1);
    test(6, new int[] { -1, -2 }, 1);
    test(7, new int[] { 1 }, 2);
    test(8, new int[] { 0, 2, 2, 1, 1 }, 3);
    test(9, new int[] { 1, 1 }, 2);
  }

  private void test(int testId, int[] nums, int exp) {
    int result = firstMissingPositive(nums);

    if (result != exp) {
      System.out.println(
          "Error! testId: " + testId + ", nums" + Arrays.toString(nums) + ", exp: " + exp + ", result: " + result);
    }
  }
}