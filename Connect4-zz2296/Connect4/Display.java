// interface for display
public interface Display {

  // print out the board
  void disBoard(String s);

  // print out the winner
  void disWin(char player);

  // print out the drwa result
  void disDraw();

  // print out the inbalid input
  void disInvalid();

  void disInput(char player);

}