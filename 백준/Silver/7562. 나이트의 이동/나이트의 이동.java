import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
		int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int n = sc.nextInt();
			int[][] board = new int[n][n];
			LinkedList<Integer> x = new LinkedList<>();
			LinkedList<Integer> y = new LinkedList<>();
			x.add(sc.nextInt()); y.add(sc.nextInt());
			int a = sc.nextInt(), b = sc.nextInt();
			while (a != x.peek() || b != y.peek()) {
				int cx = x.poll(), cy = y.poll();
				for (int i = 0; i < 8; i++) {
					int nx = cx + dx[i], ny = cy + dy[i];
					if (nx < 0 || nx >= n || ny < 0 || ny >= n || board[nx][ny] > 0) continue;
					x.offer(nx); y.offer(ny); board[nx][ny] = board[cx][cy] + 1;
				}
			}
			System.out.println(board[a][b]);
		}
	}
}