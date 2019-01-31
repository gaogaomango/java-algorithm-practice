import java.util.Date;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

class GetUserInput {

  public static void main(String[] args) {
    if (isYes()) {
      System.out.println("yes!!");
    } else {
      System.out.println("no!!");
    }
  }

  private static boolean isYes() {
    String answer = getUserInput();
    if (answer.toLowerCase().startsWith("y")) {
      return true;
    } else {
      return false;
    }

  }

  private static String getUserInput() {
    String answer = null;

    System.out.println("コーヒーに砂糖とミルクを入れますか？ (y/n)");

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    try {
      answer = br.readLine();
    } catch (IOException e) {
      e.printStackTrace();
    }
    if (answer == null) {
      return "no";
    }
    return answer;
  }
}
