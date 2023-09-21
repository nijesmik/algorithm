import java.util.*;

public class Solution {
	static int n;
	static int[][] cheese;
	static boolean[][] visit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			n = sc.nextInt();
			int max = 0;
			cheese = new int[n+2][n+2];
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					cheese[i][j] = sc.nextInt();
					max = Math.max(max, cheese[i][j]);
				}
			}
			int ans = 1;
			for (int day = 1; day <= max; day++) {
				for (int i = 1; i <= n; i++) {
					for (int j = 1; j <= n; j++) {
						if (cheese[i][j] == day)
							cheese[i][j] = 0;
					}
				}
				ans = Math.max(ans, getCount());
			}
			System.out.printf("#%d %d\n", t, ans);
		}
	}
	static int getCount() {
		int cnt = 0;
		visit = new boolean[n+1][n+1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (cheese[i][j] > 0 && !visit[i][j]) {
					bfs(i, j);
					cnt++;
				}
			}
		}
		return cnt;
	}

	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	static void bfs(int r, int c) {
		Queue<Integer[]> q = new LinkedList<>();
		q.add(new Integer[]{r, c});
		visit[r][c] = true;
		while (!q.isEmpty()) {
			Integer[] pop = q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = pop[0] + dr[i], nc = pop[1] + dc[i];
				if (cheese[nr][nc] > 0 && !visit[nr][nc]) {
					q.add(new Integer[]{nr, nc});
					visit[nr][nc] = true;
				}
			}
		}
	}
}