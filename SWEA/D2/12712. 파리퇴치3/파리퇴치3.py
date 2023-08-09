import java.util.Scanner;

public class Solution {
	static int[][] map;
	static int n;
	static int m;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			n = sc.nextInt();
			m = sc.nextInt();
			map = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++)
					map[i][j] = sc.nextInt();
			}
			int ans = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++)
					ans = Math.max(ans, spray(i, j));
			}
			System.out.printf("#%d %d\n", t, ans);
		}
	}

	static int spray(int x, int y) {
		int sum1 = -map[x][y];
		int sum2 = -map[x][y];
		for (int i = -m+1; i < m; i++) {
			if (0 <= x+i && x+i < n) {
				sum1 += map[x+i][y];
				if (0 <= y+i && y+i < n) sum2 += map[x+i][y+i];
			}
			if (0 <= y+i && y+i < n) {
				sum1 += map[x][y+i];
				if (0 <= x-i && x-i < n) sum2 += map[x-i][y+i];
			}
		}
		return Math.max(sum1, sum2);
	}
}