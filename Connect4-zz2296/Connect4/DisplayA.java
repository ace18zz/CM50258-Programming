// Class for command line interface display functionality

public class DisplayA implements Display {

  public void disBoard(String s) {
    System.out.println(s);
  }

  public void disInvalid() {
    System.out.println("Invalid input");
  }

  public void disWin(char player) {
    System.out.println(player + " win");
  }

  public void disInput(char player) {
    System.out.println(player + " it is your turn: ");
  }

  public void disDraw() {
    System.out.println("This game is draw");
  }

}