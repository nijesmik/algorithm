import java.util.*;

public class Main {
	static int sizeR, sizeC, cnt;
	static boolean[][] board, visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sizeR = sc.nextInt();
		sizeC = sc.nextInt();
		board = new boolean[sizeR][sizeC];
		visited = new boolean[sizeR][sizeC];
		int n = sc.nextInt();
		while (n-- > 0) {
			int c1 = sc.nextInt(), r1 = sc.nextInt();
			int c2 = sc.nextInt(), r2 = sc.nextInt();
			for (int i = r1; i < r2; i++) {
				for (int j = c1; j < c2; j++) {
					board[i][j] = true;
				}
			}
		}
		for (int i = 0; i < sizeR; i++) {
			for (int j = 0; j < sizeC; j++) {
				cnt = 0;
				dfs(i, j);
				if (cnt > 0) {
					pq.add(cnt);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(pq.size()).append('\n');
		while (!pq.isEmpty()) {
			sb.append(pq.poll()).append(' ');
		}
		System.out.println(sb);
	}

	static int[] dr = { 1, -1, 0, 0 }, dc = { 0, 0, 1, -1 };
	static PriorityQueue<Integer> pq = new PriorityQueue<>();

	static void dfs(int r, int c) {
		if (r < 0 || r >= sizeR || c < 0 || c >= sizeC || board[r][c] || visited[r][c]) {
			return;
		}
		cnt++;
		visited[r][c] = true;
		for (int i = 0; i < 4; i++) {
			dfs(r + dr[i], c + dc[i]);
		}
	}
}