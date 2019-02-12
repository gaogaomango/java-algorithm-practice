import java.util.Date;
import java.util.HashSet;
import java.util.Set;

class ValidSudoku {
  public static void main(String[] args) {
    Date start = new Date();
    ValidSudoku app = new ValidSudoku();
    app.run();

    Date end = new Date();
    System.out.println("Time: " + (end.getTime() - start.getTime()));
  }

  // private static int HORIZONTAL_SUDOKU_PILE = 3;
  // private static int VERTICAL_SUDOKU_PILE = 3;
  // private static int HORIZONTAL_SUDOKU = 3;
  // private static int VERTICAL_SUDOKU = 3;

  // private Map<Integer, Boolean> statusMap = new HashMap<>();

  public boolean isValidSudoku(char[][] board) {
    Set seen = new HashSet();
    for (int i = 0; i < 9; ++i) {
      for (int j = 0; j < 9; ++j) {
        if (board[i][j] != '.') {
          String b = "(" + board[i][j] + ")";
          if (!seen.add(b + i) || !seen.add(j + b) || !seen.add(i / 3 + b + j / 3))
            return false;
        }
      }
    }
    return true;
  }

  // public boolean isValidSudoku(char[][] board) {
  // for (int i = 0; i < VERTICAL_SUDOKU_PILE; i++) {
  // for (int j = 0; j < HORIZONTAL_SUDOKU_PILE; j++) {
  // setInitialMap();
  // for (int y = i * VERTICAL_SUDOKU; y < i * VERTICAL_SUDOKU + VERTICAL_SUDOKU;
  // y++) {
  // for (int x = j * HORIZONTAL_SUDOKU; x < j * HORIZONTAL_SUDOKU +
  // HORIZONTAL_SUDOKU; x++) {
  // try {
  // char c = board[x][y];
  // if (c == '.') {
  // continue;
  // }
  // if (!Character.isDigit(c)) {
  // return false;
  // }

  // Integer tmpI = Integer.parseInt(String.valueOf(c));
  // if (tmpI.intValue() >= 10 || tmpI.intValue() < 1) {
  // return false;
  // }
  // if (statusMap.get(tmpI)) {
  // return false;
  // }
  // statusMap.put(tmpI, true);
  // } catch (NumberFormatException e) {
  // e.printStackTrace();
  // continue;
  // }
  // }
  // }
  // }
  // }

  // return true;
  // }

  // private void setInitialMap() {
  // statusMap.clear();
  // statusMap.put(1, false);
  // statusMap.put(2, false);
  // statusMap.put(3, false);
  // statusMap.put(4, false);
  // statusMap.put(5, false);
  // statusMap.put(6, false);
  // statusMap.put(7, false);
  // statusMap.put(8, false);
  // statusMap.put(9, false);
  // }

  private void run() {
    char[][] board1 = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
        { '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
        { '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
        { '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
        { '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
    test(board1, true);

    char[][] board2 = { { '8', '3', '.', '.', '7', '.', '.', '.', '.' },
        { '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
        { '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
        { '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
        { '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
    test(board2, false);

    char[][] board3 = { { '.', '.', '4', '.', '.', '.', '6', '3', '.' },
        { '.', '.', '.', '.', '.', '.', '.', '.', '.' }, { '5', '.', '.', '.', '.', '.', '.', '9', '.' },
        { '.', '.', '.', '5', '6', '.', '.', '.', '.' }, { '4', '.', '3', '.', '.', '.', '.', '.', '1' },
        { '.', '.', '.', '7', '.', '.', '.', '.', '.' }, { '.', '.', '.', '5', '.', '.', '.', '.', '.' },
        { '.', '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '.', '.', '.', '.' } };
    test(board3, false);

    char[][] board4 = { { '.', '.', '.', '.', '.', '.', '.', '.', '.' },
        { '.', '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '.', '.', '.', '.' },
        { '.', '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '.', '.', '.', '.' },
        { '.', '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '.', '.', '.', '.' },
        { '.', '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '.', '.', '.', '.' } };
    test(board4, true);

  }

  private void test(char[][] board, boolean exp) {
    boolean result = isValidSudoku(board);

    if (result != exp) {
      System.out.println("Error! input: ");
      for (char[] ca : board) {
        StringBuilder sb = new StringBuilder();
        for (char c : ca) {
          if (sb.length() != 0) {
            sb.append(" ");
          }
          sb.append(c);
        }
        System.out.println(sb.toString());
      }
      System.out.println("exp: " + exp);
    }
  }
}