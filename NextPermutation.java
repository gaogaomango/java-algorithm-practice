import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collectors;

class NextPermutation {
  public static void main(String[] args) {
    Date start = new Date();
    NextPermutation app = new NextPermutation();
    app.run();

    Date end = new Date();
    System.out.println("Time: " + (end.getTime() - start.getTime()));
  }

  public void nextPermutation(int[] nums) {
    if (nums == null || nums.length <= 1) {
      return;
    }

    int position = nums.length - 2;

    while (position >= 0 && nums[position] >= nums[position + 1]) {
      position--;
    }

    if (position >= 0) {
      int changePosition = nums.length - 1;
      while (changePosition > 0 && nums[changePosition] <= nums[position]) {
        changePosition--;
      }
      swap(nums, position, changePosition);
    }
    int reversePosition = nums.length - 1;
    reverse(nums, position + 1, reversePosition);
  }

  private void swap(int[] nums, int position, int changePosition) {
    int tmp = nums[position];
    nums[position] = nums[changePosition];
    nums[changePosition] = tmp;
  }

  private void reverse(int[] nums, int position, int reversePosition) {
    while (position < reversePosition) {
      swap(nums, position++, reversePosition--);
    }
  }

  private void run() {
    test(new int[] { 1, 2, 3 }, new int[] { 1, 3, 2 });
    test(new int[] { 3, 2, 1 }, new int[] { 1, 2, 3 });
    test(new int[] { 1, 1, 5 }, new int[] { 1, 5, 1 });
    test(new int[] { 1, 3, 2 }, new int[] { 2, 1, 3 });
    test(new int[] { 5, 1, 1 }, new int[] { 1, 1, 5 });
  }

  private void test(int[] nums, int[] expNums) {
    nextPermutation(nums);

    if (nums.length != expNums.length) {
      System.out.print("Error! result and exp have different length of list!");
      printNums(nums, expNums);
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != expNums[i]) {
        System.out.print("Error! ");
        printNums(nums, expNums);
        return;
      }
    }
  }

  private void printNums(int[] nums, int[] expNums) {
    System.out
        .print(", result: " + Arrays.stream(nums).boxed().map(n -> n.toString()).collect(Collectors.joining(", ")));
    System.out.print(
        ", expectation: " + Arrays.stream(expNums).boxed().map(n -> n.toString()).collect(Collectors.joining(", ")));
  }
}