import java.util.Scanner;

public class Solution {
	static int[] dx = {1, 1, -1, -1};
	static int[] dy = {1, -1, -1, 1};
	static int[][] map;
	static int n, ans, startX, startY;
	static boolean[] visit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			n = sc.nextInt(); ans = -1;
			visit =  new boolean[101];
			map = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++)
					map[i][j] = sc.nextInt();
			}
			for (int i = 0; i < n; i++) {
				for (int j = 1; j < n-1; j++) {
					startX = i; startY = j;
					check(i, j, 0, 1);
				}
			}
			System.out.printf("#%d %d\n", t, ans);
		}
	}
	static void check(int x, int y, int dir, int cnt) {
		if (dir > 3) return;
		int nx = x+dx[dir], ny = y+dy[dir];
		if (nx < 0 || nx >= n || ny < 0 || ny >= n) return;
		int desert = map[nx][ny];
		if (visit[desert]) return;
		if (nx == startX && ny == startY) {
			ans = Math.max(ans, cnt);
			return;
		}
		visit[desert] = true;
		check(nx, ny, dir, cnt+1);
		check(nx, ny, dir+1, cnt+1);
		visit[desert] = false;
	}
}