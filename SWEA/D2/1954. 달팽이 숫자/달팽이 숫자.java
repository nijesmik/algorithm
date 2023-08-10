import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			int[][] board = new int[n][n];
			int num = 1, x = 0, y = 0, dir = 0;
			int[] dy = {1, 0, -1, 0}, dx = {0, 1, 0, -1};
			while (num <= n*n) {
				board[x][y] = num++;
				x += dx[dir];
				y += dy[dir];
				if (x == n || x < 0 || y == n || y < 0 || board[x][y] != 0) {
					x -= dx[dir];
					y -= dy[dir];
					dir = (dir + 1)%4;
					x += dx[dir];
					y += dy[dir];
				}
			}
			System.out.printf("#%d\n", t);
			for (int[] row : board) {
				for (int k : row)
					System.out.printf("%d ", k);
				System.out.println();
			}
		}
	}
}