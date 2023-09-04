import java.util.Scanner;

public class Solution {
	static class Desert {
		int x;
		int y;
		int desert;

		Desert(int i, int j, int num) {
			x = i;
			y = j;
			desert = num;
		}
	}
	static int[] dx = {1, 1, -1, -1};
	static int[] dy = {1, -1, -1, 1};
	static Desert[][] map;
	static int n, ans;
	static boolean[] visit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			n = sc.nextInt(); ans = -1;
			visit =  new boolean[101];
			map = new Desert[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++)
					map[i][j] = new Desert(i, j, sc.nextInt());
			}
			for (int i = 0; i < n; i++) {
				for (int j = 1; j < n-1; j++)
					check(map[i][j], map[i][j], 0, 1);
			}
			System.out.printf("#%d %d\n", t, ans);
		}
	}
	static void check(Desert prev, Desert start, int dir, int cnt) {
		if (dir > 3) return;
		int curX = prev.x+dx[dir], curY = prev.y+dy[dir];
		if (curX < 0 || curX >= n || curY < 0 || curY >= n) return;
		Desert cur = map[curX][curY];
		if (visit[cur.desert]) return;
		if (curX == start.x && curY == start.y) {
			ans = Math.max(ans, cnt);
			return;
		}
		visit[cur.desert] = true;
		check(cur, start, dir, cnt+1);
		check(cur, start, dir+1, cnt+1);
		visit[cur.desert] = false;
	}
}