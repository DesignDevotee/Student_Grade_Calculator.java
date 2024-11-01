import java.util.Scanner;

final class TicTacToe {  

    boolean gameover = false;
    char playerX = 'X'; 
    char playerO = 'O';
    char player = playerX;
    char[][] board = new char[3][3];
    Scanner sc = new Scanner(System.in);

    public TicTacToe() {  
        int count = 1;
        for (char[] board1 : board) {
            for (int j = 0; j < board1.length; j++) {
                board1[j] = (char) ('0' + count);
                count++;
            }
        }
        show(); 
        System.out.println();
    }

    public void show() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + board[i][j] + " ");
                if (j < 2) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("------------");
            }
        }
    }

    public int makemove() {
        int index;
        while (true) {  
            System.out.println("Player " + player + "'s turn.");
            System.out.print("Enter field (1-9): ");
            int n = sc.nextInt();
            index = n-1;


            if (index < 0 || index > 8) {
                System.out.println("Invalid input! Please enter a number between 1 and 9.");
                continue;
            }

            int i = index / 3;
            int j = index % 3;

            if (board[i][j] == 'X' || board[i][j] == 'O') {
                System.out.println("Field already occupied! Choose another field.");
            } else {
                return index;
            }
        }
    }

    public boolean checkwin() {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) || 
                (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }
        return (board[0][0] == player && board[1][1] == player && board[2][2] == player) || 
               (board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }

    public boolean checkdraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (Character.isDigit(board[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }

    public void play() {
        while (!gameover) { 
            int index = makemove();
            int i = index / 3;
            int j = index % 3;
            board[i][j] = player;
            show();
            System.out.println();
            if (checkwin()) {
                System.out.println("Player " + player + " won!");
                gameover = true;
            } else if (checkdraw()) {
                System.out.println("Draw!");
                gameover = true;
            } else {
                player = (player == playerX) ? playerO : playerX;
            }
            System.out.println();
        }
    }
}

public class TicTacToeMain {

    public static void main(String[] args) {
        TicTacToe t1 = new TicTacToe();  
        t1.play();
    }
}
