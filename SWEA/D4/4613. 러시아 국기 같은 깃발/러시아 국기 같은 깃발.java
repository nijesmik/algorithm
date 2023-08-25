import java.util.Scanner;

public class Solution {
	static char[][] board;
	static int n, m;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			n = sc.nextInt(); m = sc.nextInt();
			board = new char[n][];
			for (int i = 0; i < n; i++) {
				board[i] = sc.next().toCharArray();
			}
			System.out.printf("#%d %d\n", t, check());
		}
	}

	static int check() {
		int min = n*m;
		for (int w = 1; w <= n-2; w++) {
			for (int b = 1; b <= n-2; b++) {
				for (int r = 1; r <= n-2; r++) {
					if (w + b + r != n) continue;
					min = Math.min(color(w, b, r), min);
 				}
			}
		}
		return min;
	}

	static int color(int w, int b, int r) {
		int cnt = 0;
		for (int i = 0; i < w; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j] != 'W') cnt++;
			}
		}
		for (int i = w; i < w+b; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j] != 'B') cnt++;
			}
		}
		for (int i = w+b; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j] != 'R') cnt++;
			}
		}
		return cnt;
	}
}