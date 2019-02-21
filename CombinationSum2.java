import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

class CombinationSum2 {
  public static void main(String[] args) {
    Date start = new Date();
    CombinationSum2 app = new CombinationSum2();
    app.run();

    System.out.println("Time: " + (new Date().getTime() - start.getTime()));
  }

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    Arrays.sort(candidates);
    List<List<Integer>> result = new ArrayList<>();
    helper(candidates, target, 0, new ArrayList<>(), result);
    return result;
  }

  private void helper(int[] candidates, int target, int index, List<Integer> tmpList, List<List<Integer>> result) {
    if (target == 0) {
      List<Integer> tmp = new ArrayList<>(tmpList);
      result.add(tmp);
      return;
    }
    int entered = 0;
    for (int i = index; i < candidates.length; i++) {
      if (entered != candidates[i]) {
        if (target - candidates[i] < 0) {
          break;
        }
        tmpList.add(candidates[i]);
        entered = candidates[i];
        helper(candidates, target - candidates[i], i + 1, tmpList, result);
        tmpList.remove(tmpList.size() - 1);
      }
    }
  }

  private void run() {

    test(1, new int[] { 10, 1, 2, 7, 6, 1, 5 }, 8,
        Arrays.asList(Arrays.asList(1, 7), Arrays.asList(1, 2, 5), Arrays.asList(2, 6), Arrays.asList(1, 1, 6)));
    test(2, new int[] { 2, 5, 2, 1, 2 }, 5, Arrays.asList(Arrays.asList(1, 2, 2), Arrays.asList(5)));
  }

  private void test(int testId, int[] candidates, int target, List<List<Integer>> exp) {

    List<List<Integer>> result = combinationSum(candidates, target);

    Comparator<List<Integer>> c = new Comparator<List<Integer>>() {
      @Override
      public int compare(List<Integer> l1, List<Integer> l2) {
        for (int i = 0; i < Math.min(l1.size(), l2.size()); i++) {

          int com = l1.get(i).compareTo(l2.get(i));
          if (com != 0) {
            return com;
          }
        }
        return Integer.compare(l1.size(), l2.size());
      }
    };

    Collections.sort(result, c);
    Collections.sort(exp, c);

    if (result == null) {
      System.out.println("Error! test id: " + testId + ", result is null");
      return;
    }

    if (result.size() != exp.size()) {
      System.out.println("Error! size is defferent! test id: " + testId + ", result: "
          + result.stream().flatMap(List::stream).map(it -> String.valueOf(it)).collect(Collectors.joining(", "))
          + ", exp: "
          + exp.stream().flatMap(List::stream).map(it -> String.valueOf(it)).collect(Collectors.joining(", ")));
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