import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt(), k = sc.nextInt();
			int[][] board = new int[n+1][n+1];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++)
					board[i][j] = sc.nextInt();
			}
			int ans = 0;
			for (int i = 0; i < n; i++) {
				int j = 0;
				while (j < n) {
					int cnt = 0;
					while (board[i][j+cnt] == 1) cnt++;
					if (cnt == k) ans++;
					j += cnt == 0 ? 1 : cnt;
				}
				j = 0;
				while (j < n) {
					int cnt = 0;
					while (board[j+cnt][i] == 1) cnt++;
					if (cnt == k) ans++;
					j += cnt == 0 ? 1 : cnt;
				}
			}
			System.out.printf("#%d %d\n", t, ans);
		}
	}
}