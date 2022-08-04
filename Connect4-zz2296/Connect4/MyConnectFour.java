import java.util.ArrayList;

public class MyConnectFour {

    private Board board;
    private Display dis;

    public MyConnectFour() {

        System.out.println("Welcome to Connect 4");
        System.out.println("There are 2 players red and yellow");
        System.out.println("Player 1 is Red, Player 2 is Yellow");
        System.out.println("To play the game type in the number of the column you want to drop you counter in");
        System.out.println("A player wins by connecting 4 counters in a row - vertically, horizontally or diagonally");
        System.out.println("");

        board = new Board(6, 7);
        dis = new DisplayA();// display start state of board
        dis.disBoard(board.toString());
        playGame();
    }

    public void playGame() {
        int currentPlayer = 0;
        int column = 0;
        int turn = board.getTurns();

        boolean isValid = false;
        boolean win = false;

        // players
        Player1 player1 = new Player1('x');
        Player2 player2 = new Player2('o');

        ArrayList<Player> players = new ArrayList<>();
        // add players to arraylist
        players.add(player1);
        players.add(player2);

        for (int i = 0; i <= turn + 1; i++) {

            if (i == turn + 1) {
                dis.disDraw();
                break;
            }

            // get move
            char nowCounter = players.get(currentPlayer).getCounter();
            int countSize = (currentPlayer + 1) % players.size();
            String borad = board.toString();

            // keep move unitl is invalid.
            do {
                dis.disInput(nowCounter);
                column = players.get(currentPlayer).getMove();
                isValid = board.isInputValid(board.toArray(0, column)[1]);

                if (!isValid) {
                    dis.disInvalid();
                }
            } while (!isValid);
            // check win condition
            win = checkWin(nowCounter, board);
            if (win) {
                dis.disWin(nowCounter);
                break;
            } else {
                // switch/swap player
                currentPlayer = countSize;
            }
            // place counter
            char competitor = players.get(countSize).getCounter();
            board.placeCounter(nowCounter, competitor, column);

            dis.disBoard(borad);// print current board

        }

    }

    public boolean checkWin(char player, Board board) {

        boolean win = false;// at begging did not win yet so false.
        int x = board.getRows();
        int y = board.getCols();

        // check
        for (int row = 0; row <= x - 4; row++) {
            for (int column = 0; column <= y - 4; column++) {
                boolean inALine = true;
                for (int i = 0; i < 4 && inALine; i++) {
                    char check = board.getBoard()[row + i][column + i];
                    if (check != player) {
                        inALine = false;
                    }
                }
                if (inALine) {
                    win = true;
                }
            }
        }
        // Check diagonal orientation

        for (int row = x - 1; row >= 3; row--) {
            for (int column = 0; column <= y - 4; column++) {
                boolean inALine = true;
                for (int i = 0; i < 4 && inALine; i++) {
                    char checkD = board.getBoard()[row - i][column + i];
                    if (checkD != player) {
                        inALine = false;
                    }
                }
                if (inALine) {
                    win = true;
                }
            }
        }
        // check horizontal
        int count = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                char checkH = board.getBoard()[i][j];
                if (checkH == player) {
                    count = count + 1;
                    if (count >= 4) {
                        win = true;
                    }
                } else {
                    count = 0;
                }

            }

        }

        // check vertical
        count = 0;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                char checkV = board.getBoard()[j][i];
                if (checkV == player) {
                    count = count + 1;
                    if (count >= 4) {
                        win = true;
                    }
                } else {
                    count = 0;
                }
            }
        }
        return win;
    }
}
