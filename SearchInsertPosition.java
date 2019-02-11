import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collectors;

class SearchInsertPosition {
  public static void main(String[] args) {
    Date start = new Date();
    SearchInsertPosition app = new SearchInsertPosition();
    app.run();

    Date end = new Date();
    System.out.println("Time: " + (end.getTime() - start.getTime()));
  }

  public int searchInsert(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int low = 0;
    int high = nums.length - 1;
    int mid = 0;

    if (nums[high] < target) {
      return high + 1;
    }
    if (nums[low] >= target) {
      return 0;
    }

    while (low < high) {
      mid = (low + high) / 2;
      if (nums[mid] == target) {
        return mid;
      }

      if (nums[mid] >= target) {
        high = mid;
      } else {
        low = mid + 1;
      }
    }

    return nums[low] >= target ? low : low + 1;
  }

  private void run() {
    test(new int[] { 1, 3, 5, 6 }, 5, 2);
    test(new int[] { 1, 3, 5, 6 }, 2, 1);
    test(new int[] { 1, 3, 5, 6 }, 7, 4);
    test(new int[] { 1, 3, 5, 6 }, 0, 0);
    test(new int[] { 1, 3 }, 2, 1);
    test(new int[] { 1, 3 }, 3, 1);
    test(new int[] { 1, 3, 5 }, 1, 0);
    test(new int[] { 1, 3, 5 }, 4, 2);
  }

  private void test(int[] nums, int target, int exp) {
    int result = searchInsert(nums, target);

    if (result != exp) {
      System.out.println("Error! target: " + target + ",exp: " + exp + " , result: " + result + ", nums: "
          + Arrays.stream(nums).boxed().map(i -> i.toString()).collect(Collectors.joining(", ")));
    }
  }
}