import java.util.*;

class Main {
	static int[][] map;
	static int[] dx = {-1,-1,-1,0,0,1,1,1};
	static int[] dy = {-1,0,1,-1,1,-1,0,1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			if (n == 0 && m == 0) break;
			map = new int[n+2][m+2];
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= m; j++)
					map[i][j] = sc.nextInt();
			}
			int ans = 0;
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= m; j++) {
					if (map[i][j] == 1) {
						dfs(i,j);
						ans++;
					}
				}
			}
			System.out.println(ans);
		}
	}

	static void dfs(int x, int y) {
		if (map[x][y] == 0) return;
		map[x][y] = 0;
		for (int i = 0; i < 8; i++) {
			int nx = x + dx[i], ny = y + dy[i];
			dfs(nx,ny);
		}
	}
}