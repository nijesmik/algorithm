import java.util.*;

public class Solution {
	static class Node implements Comparable<Node> {
		int idx;
		long len;
		Node(int a, long b) {
			idx = a;
			len = b;
		}

		@Override
		public int compareTo(Node o) {
			return Long.compare(this.len, o.len);
		}
	}
	static int[][] pos;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for (int t = 1; t <= testcase; t++) {
			int n = sc.nextInt();
			pos = new int[n][2];
			for (int i = 0; i < n; i++) {
				pos[i][0] = sc.nextInt();
			}
			for (int i = 0; i < n; i++) {
				pos[i][1] = sc.nextInt();
			}
			double tax = sc.nextDouble();
			boolean[] visit = new boolean[n];
			long[] minLen = new long[n];
			Arrays.fill(minLen, Long.MAX_VALUE);
			minLen[0] = 0;
			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.offer(new Node(0, 0));
			long total = 0;
			int cnt = 0;
			while (!pq.isEmpty()) {
				Node v = pq.poll();
				if (visit[v.idx]) continue;
				visit[v.idx] = true;
				total += v.len;
				if (++cnt == n) break;
				for (int i = 0; i < n; i++) {
					long len = distance(v.idx, i);
					if (!visit[i] && len < minLen[i]) {
						minLen[i] = len;
						pq.offer(new Node(i, len));
					}
				}
			}
			System.out.printf("#%d %d\n", t, Math.round(tax * (double)total));
		}
	}
	static long distance(int a, int b) {
		long x = Math.abs(pos[a][0] - pos[b][0]);
		long y = Math.abs(pos[a][1] - pos[b][1]);
		return x*x + y*y;
	}
}