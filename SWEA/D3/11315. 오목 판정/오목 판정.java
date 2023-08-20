import java.util.Scanner;

public class Solution {
	static char[][] board;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			board = new char[n][];
			for (int i = 0; i < n; i++) board[i] = sc.next().toCharArray();
			System.out.printf("#%d %s\n", t, check(n));
		}
	}
	static String check(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int sum1 = 0, sum2 = 0, sum3 = 0, sum4 = 0;
				for (int k = 0; k < 5; k++) {
					if (j+k < n && board[i][j+k] == 'o') sum1++;
					if (i+k < n) {
						if (board[i+k][j] == 'o') sum2++;
						if (j+k < n && board[i+k][j+k] == 'o') sum3++;
						if (0 <= j-k && board[i+k][j-k] == 'o') sum4++;
					}
				}
				if (sum1 == 5 || sum2 == 5 || sum3 == 5 || sum4 == 5)
					return "YES";
			}
		}
		return "NO";
	}
}