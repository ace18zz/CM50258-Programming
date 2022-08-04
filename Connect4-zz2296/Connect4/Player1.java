// Class for people input - is a sublclass of player

public class Player1 extends Player {

  public Player1(char counter) {
    super(counter);
  }

  Controller usermove = new Controllers();

  public int getMove() {
    usermove.getUser();
    return pCloum();
  }

  public int pCloum() {
    return usermove.getColumn();
  }

}