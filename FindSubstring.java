import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

class FindSubstring {
  public static void main(String[] args) {
    Date start = new Date();
    FindSubstring app = new FindSubstring();
    app.run();

    Date end = new Date();
    System.out.println("Time: " + (end.getTime() - start.getTime()));
  }

  public List<Integer> findSubstringUsingMap(String s, String[] words) {
    List<Integer> indexes = new LinkedList<>();
    if (s == null || s.isEmpty() || words == null || words.length == 0) {
      return indexes;
    }
    Map<String, Integer> wordCount = new HashMap<>();
    for (String word : words) {
      if (!wordCount.containsKey(word)) {
        wordCount.put(word, 0);
      }
      wordCount.put(word, wordCount.get(word) + 1);
    }

    int len = words[0].length();
    for (int i = 0; i < len; i++) {
      Map<String, Integer> removeMap = new HashMap<>(wordCount);
      int total = words.length;
      int begin = i;
      for (int j = i; j + len - 1 < s.length(); j += len) {
        String word = s.substring(j, j + len);
        if (removeMap.containsKey(word) && removeMap.get(word) > 0) {
          removeMap.put(word, removeMap.get(word) - 1);
          total -= 1;
        } else {
          int k = begin;
          while (!s.substring(k, k + len).equals(word) && k < j) {
            removeMap.put(s.substring(k, k + len), removeMap.get(s.substring(k, k + len)) + 1);
            k += len;
            total += 1;
          }
          begin = k + len;
        }

        if (total == 0) {
          indexes.add(begin);
        }
      }
    }

    return indexes;
  }

  // find index, but slow.
  public List<Integer> findSubstring(String s, String[] words) {
    if (s == null || s.isEmpty() || words == null || words.length == 0) {
      return new ArrayList<>();
    }
    Set<Integer> result = new HashSet<>();
    int sLength = s.length();
    int aWordLength = words[0].length();
    int wordsArrLength = words.length;

    for (int i = 0; i < wordsArrLength; i++) {
      final String tmpWord = words[i];
      int fromIdx = 0;
      while (fromIdx <= sLength - wordsArrLength * aWordLength) {
        int pos = s.indexOf(tmpWord, fromIdx);
        if (pos == -1) {
          break;
        }
        fromIdx = pos + 1;
        try {
          String subStr = s.subSequence(pos, pos + wordsArrLength * aWordLength).toString();
          boolean hasWord = true;
          List<String> subStrs = new ArrayList<>();
          for (int j = 0; j < wordsArrLength; j++) {
            String tmp = subStr.substring(0, aWordLength);
            subStr = subStr.replaceFirst(tmp, "");
            subStrs.add(tmp);
          }
          for (String str : words) {
            for (int j = 0; j < subStrs.size(); j++) {
              if (subStrs.get(j).contains(str)) {
                hasWord = true;
                subStrs.remove(j);
                break;
              } else {
                hasWord = false;
              }
            }
            if (!hasWord) {
              break;
            }
          }
          if (hasWord) {
            result.add(pos);
          }

        } catch (IndexOutOfBoundsException e) {
          // not exist the position;
          continue;
        }
      }
    }

    return new ArrayList<>(result);
  }

  private void run() {
    test("thefoobarman", new String[] { "foo", "bar" }, Arrays.asList(3));
    test("barfoothefoobarman", new String[] { "foo", "bar" }, Arrays.asList(0, 9));
    test("wordgoodgoodgoodbestword", new String[] { "word", "good", "best", "word" }, Arrays.asList());
    test("wordgoodgoodgoodbestword", new String[] { "word", "good", "best", "good" }, Arrays.asList(8));
    test("ababaab", new String[] { "ab", "ba", "ba" }, Arrays.asList(1));
    test(
        "abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababab",
        new String[] { "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba",
            "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba",
            "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba",
            "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba",
            "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba",
            "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba",
            "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba",
            "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba",
            "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba",
            "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba",
            "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba",
            "ab", "ba", "ab", "ba" },
        Arrays.asList());
  }

  private void test(String s, String[] words, List<Integer> expList) {
    // List<Integer> result = findSubstring(s, words);
    List<Integer> result = findSubstringUsingMap(s, words);

    Collections.sort(result);
    Collections.sort(expList);
    if (result.size() != expList.size()) {
      System.out.print("Error! result and exp have different length of list! String: " + s);
      System.out.print(", result: " + result.stream().map(n -> n.toString()).collect(Collectors.joining(", ")));
      System.out.println(", expList: " + expList.stream().map(n -> n.toString()).collect(Collectors.joining(", ")));
      return;
    }

    for (int i = 0; i < result.size(); i++) {
      if (result.get(i).intValue() != expList.get(i).intValue()) {
        System.out.print("Error! String s: " + s);
        System.out.print(", result: " + result.stream().map(n -> n.toString()).collect(Collectors.joining(", ")));
        System.out.println(", expList: " + expList.stream().map(n -> n.toString()).collect(Collectors.joining(", ")));
        return;
      }
    }
  }
}