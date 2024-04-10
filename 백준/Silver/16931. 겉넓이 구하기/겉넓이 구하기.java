import java.util.Scanner;

public class Main {
    static int boardC, total;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int boardR = sc.nextInt();
        boardC = sc.nextInt();
        int[][] board = new int[boardR + 2][boardC + 2];
        total = 0;
        for (int i = 1; i <= boardR; i++) {
            for (int j = 1; j <= boardC; j++) {
                board[i][j] = sc.nextInt();
                if (board[i][j] > 0) {
                    total += 2; // top and bottom
                }
                total += Math.max(0, board[i][j] - board[i][j - 1]); // left
            }
            right(board[i]);
        }
        for (int j = 1; j <= boardC; j++) {
            for (int i = 1; i <= boardR; i++) {
                total += Math.max(0, board[i][j] - board[i - 1][j]) // back
                        + Math.max(0, board[boardR - i + 1][j] - board[boardR - i + 2][j]); // front
            }
        }
        System.out.println(total);
    }

    static void right(int[] row) {
        for (int i = boardC; i > 0; i--) {
            total += Math.max(0, row[i] - row[i + 1]);
        }
    }
}