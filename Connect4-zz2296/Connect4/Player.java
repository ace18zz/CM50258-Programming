// This class is a abstract class to creat a array list for two players.
public abstract class Player {

	private char counter;

	public Player(char counter) {
		this.counter = counter;
	}

	abstract int getMove();

	public char getCounter() {
		return counter;
	}
}