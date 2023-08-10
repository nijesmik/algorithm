import java.util.Scanner;

public class Solution {
	static int[][] board;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			board = new int[n][n];
			for (int i = 0; i < n; i++) {
				String[] tmp = sc.next().split("");
				for (int j = 0; j < n; j++)
					board[i][j] = tmp[j].equals(".") ? 0 : 1;
			}
			System.out.printf("#%d %s\n", t, check(n));
		}
	}
	static String check(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int sum1 = 0, sum2 = 0, sum3 = 0, sum4 = 0;
				for (int k = 0; k < 5; k++) {
					if (j+k < n) sum1 += board[i][j+k];
					if (i+k < n) {
						sum2 += board[i+k][j];
						if (j+k < n) sum3 += board[i+k][j+k];
						if (0 <= j-k) sum4 += board[i+k][j-k];
					}
				}
				if (sum1 == 5 || sum2 == 5 || sum3 == 5 || sum4 == 5)
					return "YES";
			}
		}
		return "NO";
	}
}
