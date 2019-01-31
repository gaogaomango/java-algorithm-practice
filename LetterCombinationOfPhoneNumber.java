import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

class LetterCombinationOfPhoneNumber {
  public static void main(String[] args) {
    Date start = new Date();

    List<String> list1 = Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
    letterCombinationsTest("23", list1);

    Date end = new Date();
    System.out.println(end.getTime() - start.getTime() + " ms");

  }

  public static List<String> letterCombinations(String digits) {
    if (digits == null || digits.isEmpty()) {
      // return empty list
      return new ArrayList<>();
    }

    List<String> list = new ArrayList<>();
    list.add("");
    String[] dataArray = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    for (int i = 0; i < digits.length(); i++) {
      List<String> tmpList = new ArrayList<>();
      char[] tmpCharArray = dataArray[digits.charAt(i) - '0'].toCharArray();
      if (list.isEmpty()) {
        list.add("");
      }
      for (String str : list) {
        for (int j = 0; j < tmpCharArray.length; j++) {
          tmpList.add(str + tmpCharArray[j]);
        }
      }
      list = tmpList;

    }

    return list;
  }

  private static void letterCombinationsTest(String digits, List<String> expectationList) {
    List<String> result = letterCombinations(digits);
    boolean isSuccess = true;
    if (result == null || result.isEmpty()) {
      isSuccess = false;
    }
    for (int i = 0; i < result.size(); i++) {
      if (!expectationList.get(i).equals(result.get(i))) {
        isSuccess = false;
        break;
      }
    }

    if (isSuccess) {
      return;
    } else {
      System.out.println("Failed!! digits: " + digits + ", result: " + getArrayString(result) + ", expect: "
          + getArrayString(expectationList));
    }

  }

  private static String getArrayString(List<String> list) {
    StringBuilder sb = new StringBuilder();
    list.forEach(s -> {
      if (sb.length() != 0) {
        sb.append(", ");
      }
      sb.append(s);
    });
    return sb.toString();
  }
}