import java.util.Arrays;
import java.util.Scanner;
import java.util.HashMap;

public class TicTacToe {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        boolean[] seen = new boolean[9];

        HashMap <Integer, String> positions = new HashMap<>();
        int count = 1;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                String position = i +":" +j;
                positions.put(count++, position);
            }
        }

        boolean winner = false;
        for(int turn = 1; turn <= 9; turn++) {
            if(turn % 2 != 0) {
                winner = takeTurn(board, 'x', positions, seen);

            } else {
                winner = takeTurn(board, 'o', positions, seen);
            }

            if(winner) {
                break;
            }
        }

        System.out.println("Game over!!!");
        if(!winner) {
            System.out.println("It's a draw!!!");
        }
    }

    public static boolean takeTurn(char[][] board, char c, HashMap <Integer, String> positions, boolean[] seen) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Player " + c + "'s turn: ");
        int pos = sc.nextInt();

        while(!positions.containsKey(pos)) {
            System.out.println("Invalid turn, try again...");
            pos = sc.nextInt();
        }

        while(seen[pos-1]) {
            System.out.println("Position already filled, try again...");
            pos = sc.nextInt();
        }


        String key = positions.get(pos);
        int i = Integer.parseInt(key.split(":")[0]);
        int j = Integer.parseInt(key.split(":")[1]);

        board[i][j] = c;
        seen[pos-1] = true;

        for(char[] row : board) {
            System.out.println(Arrays.toString(row));
        }

        if(isWinner(board, c)) {
            System.out.println("Player " + c + " wins!!!");
            return true;
        }

        return false;
    }

    public static boolean isWinner(char[][] board, char c) {
        return (board[0][0] == c && board[0][1] == c && board[0][2] == c) ||
                (board[1][0] == c && board[1][1] == c && board[1][2] == c) ||
                (board[2][0] == c && board[2][1] == c && board[2][2] == c) ||
                (board[0][0] == c && board[1][0] == c && board[2][0] == c) ||
                (board[0][1] == c && board[1][1] == c && board[2][1] == c) ||
                (board[0][2] == c && board[1][2] == c && board[2][2] == c) ||
                (board[0][0] == c && board[1][1] == c && board[2][2] == c) ||
                (board[0][2] == c && board[1][1] == c && board[2][0] == c);
    }
}
