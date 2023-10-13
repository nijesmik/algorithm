import java.util.Scanner;

public class Main {
	static char[][] board;
	static int n, cnt1, cnt2;
	static boolean[][] visit1, visit2;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		board = new char[n][];
		for (int i = 0; i < n; i++) {
			board[i] = sc.next().toCharArray();
		}
		cnt1 = cnt2 = 0;
		visit1 = new boolean[n][n];
		visit2 = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visit1[i][j]) {
					cnt1++;
					dfs(i, j, board[i][j], visit1);
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visit2[i][j]) {
					cnt2++;
					dfs(i, j, board[i][j], visit2);
				}
			}
		}
		System.out.printf("%d %d\n", cnt1, cnt2);
	}
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	static void dfs(int r, int c, char color, boolean[][] visit) {
		if (visit[r][c]) return;
		visit[r][c] = true;
		if (board[r][c] == 'G') board[r][c] = 'R';
		for (int i = 0; i < 4; i++) {
			int nr = r+dr[i], nc = c+dc[i];
			if (nr >= 0 && nr < n && nc >= 0 && nc < n && board[nr][nc] == color)
				dfs(nr, nc, color, visit);
		}
	}
}