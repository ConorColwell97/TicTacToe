import java.util.Arrays;
import java.util.Scanner;
import java.util.HashMap;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] board = new char[3][3];
        boolean[] seen = new boolean[9];

        HashMap <Integer, String> positions = new HashMap<>();
        int count = 0;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                String position = i +":" +j;
                positions.put(count++, position);
            }
        }

        int turn = 0;

        do {
            if(turn % 2 == 0) {
                System.out.print("Player x's turn: ");
                int pos = sc.nextInt();

                while(!positions.containsKey(pos)) {
                    System.out.println("Invalid turn, try again...");
                    pos = sc.nextInt();
                }

                while(seen[pos]) {
                    System.out.println("Position already filled, try again...");
                    pos = sc.nextInt();
                }


                String key = positions.get(pos);
                int i = Integer.parseInt(key.split(":")[0]);
                int j = Integer.parseInt(key.split(":")[1]);

                board[i][j] = 'x';
                seen[pos] = true;

                if(isWinnerX(board)) {
                    System.out.println("Player x wins!!!");
                    break;
                }

            } else {
                System.out.print("Player o's turn: ");
                int pos = sc.nextInt();

                while(!positions.containsKey(pos)) {
                    System.out.println("Invalid turn, try again...");
                    pos = sc.nextInt();
                }

                while(seen[pos]) {
                    System.out.println("Position already filled, try again...");
                    pos = sc.nextInt();
                }


                String key = positions.get(pos);
                int i = Integer.parseInt(key.split(":")[0]);
                int j = Integer.parseInt(key.split(":")[1]);

                board[i][j] = 'o';
                seen[pos] = true;

                if(isWinnerO(board)) {
                    System.out.println("Player o wins!!!");
                    break;
                }
            }

            for(char[] row : board) {
                System.out.println(Arrays.toString(row));
            }
            turn++;
        } while(turn < 9);

        System.out.println("Game over!");
        for(char[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static boolean isWinnerX(char[][] board) {
        return (board[0][0] == 'x' && board[0][1] == 'x' && board[0][2] == 'x') ||
                (board[1][0] == 'x' && board[1][1] == 'x' && board[1][2] == 'x') ||
                (board[2][0] == 'x' && board[2][1] == 'x' && board[2][2] == 'x') ||
                (board[0][0] == 'x' && board[1][0] == 'x' && board[2][0] == 'x') ||
                (board[0][1] == 'x' && board[1][1] == 'x' && board[2][1] == 'x') ||
                (board[0][2] == 'x' && board[1][2] == 'x' && board[2][2] == 'x') ||
                (board[0][0] == 'x' && board[1][1] == 'x' && board[2][2] == 'x') ||
                (board[0][2] == 'x' && board[1][1] == 'x' && board[2][0] == 'x');
    }

    public static boolean isWinnerO(char[][] board) {
        return (board[0][0] == 'o' && board[0][1] == 'o' && board[0][2] == 'o') ||
                (board[1][0] == 'o' && board[1][1] == 'o' && board[1][2] == 'o') ||
                (board[2][0] == 'o' && board[2][1] == 'o' && board[2][2] == 'o') ||
                (board[0][0] == 'o' && board[1][0] == 'o' && board[2][0] == 'o') ||
                (board[0][1] == 'o' && board[1][1] == 'o' && board[2][1] == 'o') ||
                (board[0][2] == 'o' && board[1][2] == 'o' && board[2][2] == 'o') ||
                (board[0][0] == 'o' && board[1][1] == 'o' && board[2][2] == 'o') ||
                (board[0][2] == 'o' && board[1][1] == 'o' && board[2][0] == 'o');
    }
}
