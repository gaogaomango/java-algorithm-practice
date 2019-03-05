import java.util.Date;

class MultiplyStrings {
    public static void main(String[] args) {
        Date start = new Date();
        MultiplyStrings app = new MultiplyStrings();
        app.run();

        Date end = new Date();
        System.out.println("Time: " + (end.getTime() - start.getTime()));
    }

    private void run() {
        test(1, "2", "3", "6");
        test(2, "123", "456", "56088");
    }

    public String multiply(String num1, String num2) {
        char[] s1 = num1.toCharArray();
        char[] s2 = num2.toCharArray();
        int len1 = s1.length;
        int len2 = s2.length;
        int[] ans = new int[len1 + len2];

        for (int i = len2 - 1; i >= 0; i--) {
            for (int j = len1 - 1; j >= 0; j--) {
                ans[len1 + len2 - i - j - 2] += (s2[i] - '0') * (s1[j] - '0');
            }
        }
        for (int i = 0; i < len1 + len2 - 1; i++) {
            ans[i + 1] += ans[i] / 10;
            ans[i] %= 10;
        }
        StringBuilder sb = new StringBuilder();
        int i = len1 + len2 - 1;
        while (i >= 0 && ans[i] == 0) {
            i--;
        }
        if (i < 0) {
            return "0";
        }
        while (i >= 0) {
            sb.append(ans[i]);
            i--;
        }

        return sb.toString();
    }

    private void test(int testId, String num1, String num2, String exp) {
        String resultStr = multiply(num1, num2);

        if (!exp.equals(resultStr)) {
            System.out.println("Error! testId: " + testId + ", result: " + resultStr + ", exp: " + exp);
        }
    }
}