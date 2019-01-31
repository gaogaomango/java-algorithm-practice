import java.util.Date;

class TrappingRainWater {
  public static void main(String[] args) {
    Date start = new Date();

    int[] i = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
    trapTest(i, 6);
    int[] j = { 2, 0, 2 };
    trapTest(j, 2);
    int[] k = { 0, 2, 0 };
    trapTest(k, 0);
    int[] l = { 4, 2, 3 };
    trapTest(l, 1);

    Date end = new Date();
    System.out.println(end.getTime() - start.getTime() + " ms");
  }

  private static void trapTest(int[] height, int expectation) {
    int result = trap(height);
    if (result != expectation) {
      System.err.println("failed! result was " + result + " expectation was " + expectation);
    }
  }

  private static int trap(int[] height) {
    int squreMeasure = 0;
    int left = 0;
    int right = height.length - 1;

    int lmax = 0;
    int rmax = 0;

    while (left < right) {
      lmax = Math.max(lmax, height[left]);
      rmax = Math.max(rmax, height[right]);

      if (height[left] <= rmax) {
        squreMeasure += lmax - height[left];
        left++;
      } else {
        squreMeasure += rmax - height[right];
        right--;
      }
    }

    return squreMeasure;

    // int leftPostion = 0;
    // int rightPosition = height.length - 1;
    // int squreMeasure = 0;
    // int area;
    // int leftHeight;
    // int rightHeight;

    // while (leftPostion < rightPosition) {
    // area = 0;
    // leftHeight = height[leftPostion];
    // rightHeight = height[rightPosition];

    // if (leftHeight >= rightHeight) {
    // area = (rightPosition - leftPostion) * rightHeight;
    // rightPosition--;
    // } else {
    // area = (rightPosition - leftPostion) * leftHeight;
    // leftPostion++;
    // }
    // squreMeasure = area > squreMeasure ? area : squreMeasure;
    // }

    // return squreMeasure;

  }

}