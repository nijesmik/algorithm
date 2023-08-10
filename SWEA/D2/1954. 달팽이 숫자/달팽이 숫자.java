import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			int[][] board = new int[n][n];
			int num = 1;
			for (int i = 0; i < n / 2; i++) {
				for (int j = i; j < n-1-i; j++) board[i][j] = num++;
				for (int j = i; j < n-1-i; j++) board[j][n-1-i] = num++;
				for (int j = n-1-i; j > i; j--) board[n-1-i][j] = num++;
				for (int j = n-1-i; j > i; j--) board[j][i] = num++;
			}
			if (n%2 == 1) board[n/2][n/2] = num;
			System.out.printf("#%d\n", t);
			for (int[] row : board) {
				for (int k : row)
					System.out.printf("%d ", k);
				System.out.println();
			}
		}
	}
}