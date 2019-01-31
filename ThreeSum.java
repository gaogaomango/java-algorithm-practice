import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class ThreeSum {
  public static void main(String[] args) {
    Date start = new Date();

    // int[] i = { -1, 0, 1, 2, -1, -4 };
    // Integer[] tmpI = { -1, 0, -1 };
    int[] i = { -2, 0, 1, 1, 2 };
    Integer[] tmpI = { -1, 0, -1 };
    threeSumTest(i, tmpI);

    Date end = new Date();
    System.out.println(end.getTime() - start.getTime() + " ms");

  }

  private static List<List<Integer>> threeSum(int[] nums) {
    if (nums == null || nums.length == 0) {
      return new ArrayList<>();
    }
    Set<List<Integer>> tmpSet = new HashSet<>();
    Arrays.sort(nums);

    // calc pattern of set.
    for (int i = 0; i < nums.length - 2; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      int j = i + 1;
      int k = nums.length - 1;
      while (j < k) {
        int sum = nums[i] + nums[j] + nums[k];
        if (sum == 0) {
          tmpSet.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
          while (j < k && nums[j] == nums[j - 1]) {
            j++;
          }
          while (j < k && nums[k] == nums[k + 1]) {
            k--;
          }
        } else if (sum > 0) {
          k--;
        } else if (sum < 0) {
          j++;
        }
      }
    }
    return new ArrayList<>(tmpSet);
  }

  private static void addArrayElement(List<Integer> list, Integer[] integers) {
    for (Integer i : integers) {
      list.add(i);
    }
  }

  private static void threeSumTest(int[] i, Integer[] tmpI) {
    List<Integer> tmpList = new ArrayList<>();
    addArrayElement(tmpList, tmpI);
    List<List<Integer>> list = new ArrayList<>();
    list.add(tmpList);
    threeSumTest(i, list);

  }

  private static void threeSumTest(int[] nums, List<List<Integer>> expectation) {
    List<List<Integer>> result = threeSum(nums);
    boolean isSuccess = true;

    check: for (int i = 0; i < result.size(); i++) {
      for (int j = 0; j < 3; j++) {
        if (result.get(i).get(j) != expectation.get(i).get(j)) {
          isSuccess = false;
          break check;
        }
      }
    }

    if (isSuccess) {
      return;
    } else {
      System.out.println("Failed!! String[]: " + printArrayInt(nums));
      System.out.print("result: ");
      result.stream().flatMap(Collection::stream).forEach(i -> System.out.print(i + " "));
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

  private static String printArrayStr(String arr[]) {
    StringBuilder sb = new StringBuilder();
    for (String i : arr) {
      sb.append(i);
      sb.append(" ");
    }
    return sb.toString();
  }
}