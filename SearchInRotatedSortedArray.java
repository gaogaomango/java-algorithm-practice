import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collectors;

class SearchInRotatedSortedArray {
  public static void main(String[] args) {
    Date start = new Date();
    SearchInRotatedSortedArray app = new SearchInRotatedSortedArray();
    app.run();

    Date end = new Date();
    System.out.println("Time: " + (end.getTime() - start.getTime()));
  }

  public int search(int[] nums, int target) {
    int start = 0;
    int end = nums.length - 1;
    int mid = 0;
    while (start <= end) {
      mid = (start + end) / 2;
      if (nums[mid] == target) {
        return mid;
      }

      if (nums[start] <= nums[mid]) {
        if (target < nums[mid] && target >= nums[start]) {
          end = mid - 1;
        } else {
          start = mid + 1;
        }
      } else {
        if (target > nums[mid] && target <= nums[end]) {
          start = mid + 1;
        } else {
          end = mid - 1;
        }
      }
    }
    return -1;
  }

  // public int search(int[] nums, int target) {
  // boolean existsTarget = false;
  // int index = 0;
  // for (; index < nums.length; index++) {
  // if (nums[index] == target) {
  // existsTarget = true;
  // break;
  // }
  // }
  // return existsTarget ? index : -1;
  // }

  private void run() {
    test(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 0, 4);
    test(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 3, -1);
  }

  private void test(int[] nums, int target, int exp) {
    int result = search(nums, target);

    if (result != exp) {
      System.out.println("Error! exp: " + exp + " , result: " + result + ", nums: "
          + Arrays.stream(nums).boxed().map(i -> i.toString()).collect(Collectors.joining(", ")));
    }
  }
}