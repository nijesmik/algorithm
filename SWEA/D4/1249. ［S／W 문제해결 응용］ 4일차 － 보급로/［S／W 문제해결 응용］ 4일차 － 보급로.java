import java.util.*;

public class Solution {
	static class Node implements Comparable<Node>{
		int r, c, len;
		Node(int x, int y, int l) {
			r = x;
			c = y;
			len = l;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.len, o.len);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = Integer.parseInt(sc.nextLine());
		for (int t = 1; t <= testcase; t++) {
			int n = Integer.parseInt(sc.nextLine());
			char[][] map = new char[n][];
			int[][] dp = new int[n][n];
			boolean[][] visit = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				map[i] = sc.nextLine().toCharArray();
				Arrays.fill(dp[i], Integer.MAX_VALUE);
			}
			int[] dr = {1, -1, 0, 0};
			int[] dc = {0, 0, 1, -1};
			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.add(new Node(0, 0, 0));
			dp[0][0] = 0;
			while (!pq.isEmpty()) {
				Node cur = pq.poll();
				int r = cur.r, c = cur.c;
				if (visit[r][c]) continue;
				visit[r][c] = true;
				if (r == n-1 && c == n-1) break;
				for (int i = 0; i < 4; i++) {
					int nr = r+dr[i], nc = c+dc[i];
					if (nr < 0 || nr >= n || nc < 0 || nc >= n || visit[nr][nc]) continue;
					int len = cur.len + map[nr][nc] - '0';
					if (len < dp[nr][nc]) {
						dp[nr][nc] = len;
						pq.add(new Node(nr, nc, len));
					}
				}
			}
			System.out.printf("#%d %d\n", t, dp[n-1][n-1]);
		}
	}
}