public class Board {

  // instantiate grid
  private char[][] board;
  private int row;
  private int column;
  private int turn;

  public Board(int row, int column) {
    this.row = row;
    this.column = column;

    board = new char[row][column];
    turn = row * column;
  }

  // board string
  public String toString() {

    String disPlay = "";

    for (int i = 0; i < board.length; i++) {
      disPlay += ((board.length - i) + "|");
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] == '\0') { // if is is empty then add | .
          disPlay += ("   |");
        } else {
          disPlay += (" " + board[i][j] + " |");
        }
      }
      disPlay += i;
      disPlay += "\n";
    }
    disPlay += ("   1   2   3   4   5   6   7"); // append final row to string

    return disPlay;

  }

  // place counter
  public void placeCounter(char player, char competitor, int column) {

    boolean placed = false;

    int position = toArray(0, column)[1];

    for (int i = board.length - 1; i >= 0; i--) {
      if (!placed) {
        if (board[i][position] == competitor) {
          // skip
        } else if (board[i][position] != player) {
          board[i][position] = player;
          placed = true;
        }
      }
    }

  }

  public int[] toArray(int row, int column) {
    int[] coordinates = new int[2];

    coordinates[0] = (getRows() - row);
    coordinates[1] = (column - 1);

    return coordinates;
  }

  // Board Property Accessors

  int getTurns() {
    return turn;
  }

  // number of columns on the board
  int getCols() {
    return column;
  }

  // number of rows on the board
  int getRows() {
    return row;
  }

  char[][] getBoard() {
    return board;
  }

  public boolean isInputValid(int column) {
    boolean check = false;
    if ((column <= getCols() - 1) && (column >= 0)) {
      for (int r = getRows() - 1; r >= 0; r--) {
        if (board[r][column] == '\0') {
          check = true;
        }
      }

    } else {
      check = false;
    }

    return check;
  }

}