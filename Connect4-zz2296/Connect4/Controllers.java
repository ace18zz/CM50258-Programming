import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Controllers implements Controller {

	private BufferedReader in;

	// To get what user input
	public void getUser() {
		in = new BufferedReader(new InputStreamReader(System.in));
	}

	public int getColumn() {
		try {
			return Integer.parseInt(in.readLine());
		} catch (IOException e) {
			return -1;
		}
	}

}