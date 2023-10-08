import java.util.Scanner;

public class Main {
	static int[][] board;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		board = new int[21][21];
		for (int i = 1; i <= 19; i++) {
			for (int j = 1; j <= 19; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		test();
	}
	static void test() {
		for (int i = 1; i <= 19; i++) {
			for (int j = 1; j <= 19; j++) {
				if (board[i][j] > 0 && check(i, j)) {
					System.out.println(board[i][j]);
					System.out.printf("%d %d\n", i, j);
					return;
				}
			}
		}
		System.out.println(0);
	}
	static int[] dr = {1, 0, 1, -1};
	static int[] dc = {0, 1, 1, 1};
	static boolean check(int r, int c) {
		for (int i = 0; i < 4; i++) {
			if (board[r-dr[i]][c-dc[i]] == board[r][c]) continue;
			int cnt = getcount(r, c, i);
			if (cnt == 5) return true;
		}
		return false;
	}
	static int getcount(int r, int c, int idx) {
		int cnt = 0, nr = r, nc = c;
		while (board[nr][nc] == board[r][c]) {
			cnt++;
			nr += dr[idx];
			nc += dc[idx];
			if (nr < 1 || nr > 19 || nc < 1 || nc > 19) break;
		}
		return cnt;
	}
}