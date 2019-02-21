import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

class CombinationSum {
  public static void main(String[] args) {
    Date start = new Date();
    CombinationSum app = new CombinationSum();
    app.run();

    System.out.println("Time: " + (new Date().getTime() - start.getTime()));
  }

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    Arrays.sort(candidates);
    List<List<Integer>> result = new ArrayList<>();
    helper(result, candidates, 0, target, new ArrayList<>());
    return result;
  }

  private void helper(List<List<Integer>> result, int[] can, int start, int target, List<Integer> each) {
    for (int i = start; i < can.length; i++) {
      List<Integer> tmp = new ArrayList<>(each);
      if (can[i] == target) {
        tmp.add(can[i]);
        result.add(tmp);
        break;

      } else if (can[i] < target) {
        tmp.add(can[i]);
        helper(result, can, i, target - can[i], tmp);
      } else {
        break;
      }
    }
    return;
  }

  private void run() {

    test(1, new int[] { 2, 3, 6, 7 }, 7, Arrays.asList(Arrays.asList(2, 2, 3), Arrays.asList(7)));
    test(2, new int[] { 2, 3, 5 }, 8,
        Arrays.asList(Arrays.asList(2, 2, 2, 2), Arrays.asList(2, 3, 3), Arrays.asList(3, 5)));
  }

  private void test(int testId, int[] candidates, int target, List<List<Integer>> exp) {
    List<List<Integer>> result = combinationSum(candidates, target);
    if (result == null) {
      System.out.println("Error! test id: " + testId + ", result is null");
      return;
    }

    if (result.size() != exp.size()) {
      System.out.println("Error! size is defferent! test id: " + testId + ", result: "
          + result.stream().flatMap(List::stream).map(it -> String.valueOf(it)).collect(Collectors.joining(", ")));
      return;
    }

    for (int i = 0; i < result.size(); i++) {
      List<Integer> tmpResult = result.get(i);
      List<Integer> tmpExp = exp.get(i);

      if (tmpResult.size() != tmpExp.size()) {
        System.out.println("Error! size is defferent! test id: " + testId + ", tmpResult: "
            + tmpResult.stream().map(it -> String.valueOf(it)).collect(Collectors.joining(", ")) + ", tmpExp: "
            + tmpExp.stream().map(it -> String.valueOf(it)).collect(Collectors.joining(", ")));
        return;
      }
      Collections.sort(tmpResult);
      Collections.sort(tmpExp);

      if (tmpResult != null && tmpExp != null) {
        for (int j = 0; j < tmpResult.size(); j++) {
          if (tmpResult.get(j) == null) {
            System.out.println("tmpResult.get(j) == null");
          }
          if (tmpExp.get(j) == null) {
            System.out.println("tmpExp.get(j) == null");
          }
          if (tmpResult.get(j).intValue() != tmpExp.get(j).intValue()) {
            System.out.println("Error! test id:" + testId + ", result: "
                + result.stream().flatMap(List::stream).map(it -> String.valueOf(it)).collect(Collectors.joining(", "))
                + ", exp: "
                + exp.stream().flatMap(List::stream).map(it -> String.valueOf(it)).collect(Collectors.joining(", ")));

          }
        }
      }

    }

  }
}