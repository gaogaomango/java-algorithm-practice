import java.util.Date;
import java.util.regex.Pattern;

class IsMatchExtension {
  public static void main(String[] args) {
    Date startDate = new Date();

    testIsMatchExtension("", "", true);
    testIsMatchExtension("", ".", false);
    testIsMatchExtension("", ".*", true);
    testIsMatchExtension("aa", "aa", true);
    testIsMatchExtension("a6", "aa", false);
    testIsMatchExtension("aa", "a6", false);
    testIsMatchExtension("aa", "a.", true);
    testIsMatchExtension("a", "a.*", true);
    testIsMatchExtension("a", "a.?", false);

    Date endDate = new Date();
    System.out.println("first result speed: " + String.valueOf(endDate.getTime() - startDate.getTime()));
  }

  public static void testIsMatchExtension(String s, String p, boolean expectResult) {
    if (isMatch(s, p) == expectResult) {
      // do nothing
    } else {
      System.out.println("err! input: s =  " + s + ", p = " + p + ", expect: " + expectResult);
    }
  }

  public static boolean isMatch(String s, String p) {
    if (s == null || p == null) {
      return false;
    }

    if (p.length() == 0) {
      return s.length() == 0 ? s.equals(p) : false;
    }

    if (s.length() != 0 && !Pattern.matches("^[a-z]+$", s)) {
      return false;
    }

    if (!Pattern.matches("^([a-z]|\\*|\\.)+$", p)) {
      return false;
    }

    // StringBuilder regSb = new StringBuilder();
    // regSb.append("^");
    // regSb.append(p);
    // regSb.append("$");

    // System.out.println(regSb.toString());

    // return Pattern.matches(regSb.toString(), s);
    return Pattern.matches(p, s);

  }

}