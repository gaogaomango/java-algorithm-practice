import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collectors;

class FindFirstAndLastPosition {
  public static void main(String[] args) {
    Date start = new Date();
    FindFirstAndLastPosition app = new FindFirstAndLastPosition();
    app.run();

    Date end = new Date();
    System.out.println("Time: " + (end.getTime() - start.getTime()));
  }

  public int[] searchRange(int[] nums, int target) {
    int low = 0;
    int high = nums.length - 1;
    int mid = 0;
    while (low <= high) {
      mid = (low + high) / 2;
      if (nums[mid] == target) {
        int sameLow = mid - 1;
        int sameHigh = mid + 1;
        while (sameLow >= 0 && nums[sameLow] == target) {
          sameLow--;
        }
        while (sameHigh < nums.length && nums[sameHigh] == target) {
          sameHigh++;
        }
        return new int[] { sameLow + 1, sameHigh - 1 };
      }

      if (nums[mid] < target) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return new int[] { -1, -1 };
  }

  private void run() {
    test(new int[] { 5, 7, 7, 8, 8, 10 }, 8, new int[] { 3, 4 });
    test(new int[] { 5, 7, 7, 8, 8, 10 }, 6, new int[] { -1, -1 });
    test(new int[] { 2, 2 }, 2, new int[] { 0, 1 });
    test(new int[] { 1 }, 1, new int[] { 0, 0 });
  }

  private void test(int[] nums, int target, int[] exp) {
    int[] result = searchRange(nums, target);

    if (result.length != exp.length) {
      System.out.print("Error! result and exp has different length! ");
      System.out.println(
          "nums: " + Arrays.stream(nums).boxed().map(i -> i.toString()).collect(Collectors.joining(", ")) + ", target: "
              + target + ", exp: " + Arrays.stream(exp).boxed().map(i -> i.toString()).collect(Collectors.joining(", "))
              + ", result: " + Arrays.stream(result).boxed().map(i -> i.toString()).collect(Collectors.joining(", ")));
    }

    for (int i = 0; i < result.length; i++) {
      if (result[i] != exp[i]) {
        System.out.println("Error! nums: "
            + Arrays.stream(nums).boxed().map(it -> it.toString()).collect(Collectors.joining(", ")) + ", target: "
            + target + ", exp: " + Arrays.stream(exp).boxed().map(it -> it.toString()).collect(Collectors.joining(", "))
            + ", result: " + Arrays.stream(result).boxed().map(it -> it.toString()).collect(Collectors.joining(", ")));
        break;
      }
    }

  }
}