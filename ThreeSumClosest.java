import java.util.Arrays;
import java.util.Date;

class ThreeSumClosest {

  public static void main(String[] args) {
    Date start = new Date();

    int[] i = { -1, 2, 1, -4 };
    int closestExpectation = 2;
    int target = 1;
    threeSumClosestTest(i, target, closestExpectation);

    int[] i2 = { 1, 1, 1, 0 };
    int closestExpectation2 = 2;
    int target2 = -100;
    threeSumClosestTest(i2, target2, closestExpectation2);

    int[] i3 = { 0, 2, 1, -3 };
    int closestExpectation3 = 0;
    int target3 = 1;
    threeSumClosestTest(i3, target3, closestExpectation3);

    Date end = new Date();
    System.out.println(end.getTime() - start.getTime() + " ms");

  }

  private static int threeSumClosest(int[] nums, int target) {
    int result = nums[0] + nums[1] + nums[nums.length - 1];
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 2; i++) {
      int start = i + 1, end = nums.length - 1;
      while (start < end) {
        int sum = nums[i] + nums[start] + nums[end];
        if (sum > target) {
          end--;
        } else {
          start++;
        }
        if (Math.abs(sum - target) < Math.abs(result - target)) {
          result = sum;
        }
      }
    }
    return result;
  }

  private static void threeSumClosestTest(int[] nums, int target, int closestExpectation) {
    int result = threeSumClosest(nums, target);
    boolean isSuccess = result == closestExpectation;

    if (isSuccess) {
      return;
    } else {
      System.out.println("Failed!! String[]: " + printArrayInt(nums));
      System.out.print("result: " + result + ", expect: " + closestExpectation);
    }

  }

  private static String printArrayInt(int arr[]) {
    StringBuilder sb = new StringBuilder();
    for (int i : arr) {
      sb.append(i);
      sb.append(" ");
    }
    return sb.toString();
  }

}