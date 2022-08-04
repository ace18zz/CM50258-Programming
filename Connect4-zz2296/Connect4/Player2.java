// Class for bot input - is a sublclass of player

import java.util.Random;

public class Player2 extends Player {

	private Random num;

	public Player2(char counter) {
		super(counter);
	}

	public int getMove() {
		num = new Random();

		return (num.nextInt(7) + 1);
	}
}
