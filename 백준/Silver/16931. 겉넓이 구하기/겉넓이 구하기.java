import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int boardR = sc.nextInt(), boardC = sc.nextInt(), total = 0;
        int[][] board = new int[boardR + 2][boardC + 2];
        for (int i = 1; i <= boardR; i++) {
            for (int j = 1; j <= boardC; j++) {
                board[i][j] = sc.nextInt();
                if (board[i][j] > 0) {
                    total += 2;
                }
            }
        }
        for (int i = 1; i <= boardR; i++) {
            for (int j = 1; j <= boardC; j++) {
                total += Math.max(0, board[i][j] - board[i][j - 1])
                        + Math.max(0, board[i][boardC - j + 1] - board[i][boardC - j + 2])
                        + Math.max(0, board[i][j] - board[i - 1][j])
                        + Math.max(0, board[boardR - i + 1][j] - board[boardR - i + 2][j]);
            }
        }
        System.out.println(total);
    }
}