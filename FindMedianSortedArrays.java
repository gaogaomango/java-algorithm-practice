import java.util.Date;
import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.IntStream;

class FindMedianSortedArrays {

  public static void main(String[] args) {
    int[] arr1 = { 3 };
    int[] arr2 = { -2, -1 };
    System.out.println("result1: " + findMedianSortedArrays(arr1, arr2));

    int[] arr3 = {};
    int[] arr4 = { 2, 3 };
    System.out.println("result2: " + findMedianSortedArrays(arr3, arr4));

    int[] arr5 = { 1, 2 };
    int[] arr6 = { 3, 4 };
    System.out.println("result3: " + findMedianSortedArrays(arr5, arr6));

  }

  public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    Date start = new Date();

    double median = 0;
    int m = nums1.length;
    int n = nums2.length;

    int[] newArray = new int[m + n];
    System.arraycopy(nums1, 0, newArray, 0, m);
    System.arraycopy(nums2, 0, newArray, m, n);

    Arrays.sort(newArray);

    int medianIndex = (m + n) / 2;
    if ((m + n) % 2 == 0) {
      median = (newArray[medianIndex] + newArray[medianIndex - 1]) / 2.0;
    } else {
      median = newArray[medianIndex];
    }

    Date end = new Date();
    System.out.println("time: " + String.valueOf(end.getTime() - start.getTime()));

    return median;
  }
}
