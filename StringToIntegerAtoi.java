import java.util.Date;

class StringToIntegerAtoi {
  public static void main(String[] args) {
    Date start = new Date();

    // System.out.println(myAtoi("42"));
    // System.out.println(myAtoi(" -42"));
    // System.out.println(myAtoi("4183 with words"));
    // System.out.println(myAtoi("words and 987"));
    // System.out.println(myAtoi("3.141595"));
    // System.out.println(myAtoi("-"));
    // System.out.println(myAtoi("+12"));
    // System.out.println(myAtoi("+"));
    // System.out.println(myAtoi(" "));
    // System.out.println(myAtoi(" "));
    System.out.println(myAtoi("  -0012a42"));

    Date end = new Date();
    System.out.println(end.getTime() - start.getTime() + " ms");
  }

  private static int myAtoi(String str) {
    if (str == null || str.length() == 0) {
      return 0;
    }
    boolean isPlus = true;
    boolean isFoundFirstNumber = false;

    int startIndex = 0;
    int endIndex = 0;

    for (int i = 0; i < str.length(); i++) {
      char currentChar = str.charAt(i);

      if (isFoundFirstNumber) {
        if (Character.isDigit(currentChar)) {
          endIndex = i;
          isFoundFirstNumber = true;
        } else if ('.' == currentChar) {
          break;
        } else if (' ' == currentChar) {
          break;
        } else {
          break;
        }
      } else {
        if (Character.isDigit(currentChar) || '+' == currentChar || '-' == currentChar) {
          if ('-' == currentChar) {
            isPlus = false;
          }
          startIndex = i;
          endIndex = i;
          isFoundFirstNumber = true;
        } else if (' ' == currentChar) {
          continue;
        } else {
          return 0;
        }
      }
    }

    if (!isFoundFirstNumber) {
      return 0;
    }

    System.out.println("startIndex: " + startIndex);
    System.out.println("endIndex: " + endIndex);

    String resultStr = str.substring(startIndex, endIndex + 1);
    System.out.println("resultStr: " + resultStr);
    if (resultStr.length() == 1 && ("-".equals(resultStr) || "+".equals(resultStr))) {
      return 0;
    }

    try {
      return Integer.parseInt(resultStr);
    } catch (NumberFormatException e) {
      if (isPlus) {
        return Integer.MAX_VALUE;
      } else {
        return Integer.MIN_VALUE;
      }
    }
  }
}