import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ValidNumber {
  public static void main(String[] args) {
    Date start = new Date();

    equalsTest(("."), false);

    equalsTest(("e3"), false);
    equalsTest(("01."), true);
    equalsTest(("0."), true);
    equalsTest(("3"), true);
    equalsTest(("3."), true);
    equalsTest((" "), false);
    equalsTest((".1"), true);
    equalsTest((".0"), true);

    equalsTest((" 1e"), false);
    equalsTest((" -90e3 "), true);
    equalsTest(("0"), true);
    equalsTest((" 0.1 "), true);
    equalsTest(("abc"), false);
    equalsTest(("1 a"), false);
    equalsTest(("2e10"), true);
    equalsTest((" 6e-1"), true);
    equalsTest((" 99e2.5 "), false);
    equalsTest(("53.5e93"), true);
    equalsTest((" --6 "), false);
    equalsTest(("-+3"), false);
    equalsTest(("95a54e53"), false);

    Date end = new Date();
    System.out.println(end.getTime() - start.getTime() + " ms");
  }

  private static boolean isNumber(String str) {
    return str.trim().matches("[-+]?(\\d+\\.?|\\.\\d+)\\d*(e[-+]?\\d+)?");
  }

  private static boolean isNumber2(String str) {
    if (str == null || str.length() == 0) {
      return false;
    }

    // remove space in forward part.
    System.out.println(str);
    str = str.trim();
    // str = str.trim().replaceAll("^ +", "");
    // str = str.replaceAll(" +$", "");
    System.out.println(str);

    if (str == null || str.length() == 0) {
      return false;
    }

    if (".".equals(str)) {
      return false;
    }

    // String reg =
    // "^(([\\-\\+]?[1-9]{1}[0-9]*(\\.[1-9])?)|(0{1}(\\.{1}[0-9]*[1-9]{1})?))((e[1-9\\-]?[0-9]+)|[0-9]*)?$";
    String reg = "^([\\+\\-]?([\\.][0-9]+|[0-9]+(\\.[0-9]*)?))(e[\\+\\-]?[0-9]+)?$";

    // String reg =
    // "^(((([\\-\\+]?[0-9]*(\\.)?([1-9])?)|(0{1}(\\.{1}[0-9]*)?))((e[1-9\\-]?[0-9]+)|[0-9]*)?)|((([0-9]*)?(\\.{1}[0-9]*)?)))$";

    Pattern p = Pattern.compile(reg);
    Matcher m = p.matcher(str);
    return m.find();
  }

  private static boolean equalsTest(String a, boolean b) {
    boolean result = isNumber(a);
    if (result != b) {
      System.out.println("input->" + a + "<- , expect: " + b);
    }
    return result == b;
  }
}