import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class FourSum {

  public static void main(String[] args) {
    Date start = new Date();

    int[] nums1 = { 1, 0, -1, 0, -2, 2 };
    int target1 = 0;
    List<Integer> list1 = Arrays.asList(-1, 0, 0, 1);
    List<Integer> list2 = Arrays.asList(-2, -1, 1, 2);
    List<Integer> list3 = Arrays.asList(-2, 0, 0, 2);
    List<List<Integer>> expectation = Arrays.asList(list1, list2, list3);
    equalsTest(1, nums1, target1, expectation);

    Date end = new Date();
    System.out.println(end.getTime() - start.getTime() + " ms");
  }

  public static List<List<Integer>> fourSum(int[] nums, int target) {
    Set<List<Integer>> resultSet = new HashSet<>();
    List<Integer> sortedNums = Arrays.stream(nums).boxed().collect(Collectors.toList());
    ;
    Collections.sort(sortedNums);

    int secondPos = 0;
    int thirdPos = 0;

    for (int startPos = 0; startPos < sortedNums.size() - 3; startPos++) {
      if (sortedNums.get(startPos) > target)
        break;
      for (int endPos = sortedNums.size() - 1; endPos > startPos + 2; endPos--) {
        int tmpNum = 0;
        secondPos = startPos + 1;
        thirdPos = endPos - 1;
        while (secondPos < thirdPos) {
          tmpNum = sortedNums.get(startPos) + sortedNums.get(secondPos) + sortedNums.get(thirdPos)
              + sortedNums.get(endPos);
          if (target == tmpNum) {
            resultSet.add(Arrays.asList(sortedNums.get(startPos), sortedNums.get(secondPos), sortedNums.get(thirdPos),
                sortedNums.get(endPos)));
            while (thirdPos-- > secondPos && sortedNums.get(thirdPos) == sortedNums.get(thirdPos + 1))
              continue;
            while (secondPos++ < thirdPos && sortedNums.get(secondPos - 1) == sortedNums.get(secondPos))
              continue;
          } else if (target < tmpNum) {
            // while (thirdPos > secondPos && sortedNums.get(thirdPos) ==
            // sortedNums.get(thirdPos - 1)) {
            thirdPos--;
            // }
          } else if (target > tmpNum) {
            // while (secondPos < thirdPos && sortedNums.get(secondPos) ==
            // sortedNums.get(secondPos + 1)) {
            secondPos++;
            // }
          }
        }
      }
    }

    return new ArrayList<>(resultSet);
  }

  private static boolean equalsTest(int id, int[] nums, int target, List<List<Integer>> expectationList) {
    List<List<Integer>> resultList = fourSum(nums, target);

    // if (resultList == null && expectationList == null) {
    // return true;
    // }

    // if (resultList.size() != expectationList.size()) {
    // return false;
    // }

    List<Integer> tmpResult = null;
    List<Integer> tmpExpectation = null;
    boolean result = false;
    for (int i = 0; i < resultList.size(); i++) {
      result = true;
      tmpResult = new ArrayList<>(resultList.get(i));
      tmpExpectation = new ArrayList<>(expectationList.get(i));

      Collections.sort(tmpResult);
      Collections.sort(tmpExpectation);

      if (!tmpResult.equals(tmpExpectation)) {
        result = false;
        break;
      }
    }

    if (result) {
      System.out.println("success! id: " + id);
    } else {
      System.out.println("error! id: " + id);
      System.out.print("resultList:      ");
      System.out.println(
          resultList.stream().flatMap(l -> l.stream()).map(i -> String.valueOf(i)).collect(Collectors.joining(", ")));
      System.out.print("expectationList: ");
      System.out.println(expectationList.stream().flatMap(l -> l.stream()).map(i -> String.valueOf(i))
          .collect(Collectors.joining(", ")));
    }

    return result;
  }
}