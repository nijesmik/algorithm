import java.util.*;

public class Main {
	static Queue<int[]> q;
	static int rsize, csize, dir, ans;
	static int[][] map;
	static boolean[][] visit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		rsize = sc.nextInt(); csize = sc.nextInt();
		int r = sc.nextInt(), c = sc.nextInt(); dir = sc.nextInt();
		map = new int[rsize][csize];
		visit = new boolean[rsize][csize];
		for (int i = 0; i < rsize; i++) {
			for (int j = 0; j < csize; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		q = new LinkedList<>();
		q.add(new int[]{r, c});
		ans = 1;
		visit[r][c] = true;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			move(cur[0], cur[1]);
		}
		System.out.println(ans);
	}
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static void move(int r, int c) {
		int nr, nc, ndir;
		for (int i = 3; i >= 0; i--) {
			ndir = (dir+i)%4; nr = r+dr[ndir]; nc = c+dc[ndir];
			if (nr < 0 || nr >= rsize || nc < 0 || nc >= csize || visit[nr][nc] || map[nr][nc] == 1) continue;
			visit[nr][nc] = true;
			dir = ndir;
			ans++;
			q.add(new int[]{nr, nc});
			return;
		}
		nr = r-dr[dir]; nc = c-dc[dir];
		if (nr >= 0 && nr < rsize && nc >= 0 && nc < csize && map[nr][nc] == 0) q.add(new int[]{nr, nc});
	}
}