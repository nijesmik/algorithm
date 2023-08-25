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
				if (w + b + 1 <= n)
					min = Math.min(paint(w, b), min);
			}
		}
		return min;
	}

	static int paint(int w, int b) {
		int cnt = 0;
		char paint;
		for (int i = 0; i < n; i++) {
			if (i < w) paint = 'W';
			else if (i < w+b) paint = 'B';
			else paint = 'R';
			for (int j = 0; j < m; j++) {
				if (board[i][j] != paint) cnt++;
			}
		}
		return cnt;
	}
}