import java.util.*;

public class Solution {
	static class Node {
		List<Integer> list = new ArrayList<>();
	}
	static Node[] nodes;
	static boolean[] visit;
	static int n, start;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t < 11; t++) {
			nodes = new Node[101];
			visit = new boolean[101];
			for (int i = 0; i < 101; i++) {
				nodes[i] = new Node();
			}
			n = sc.nextInt();
			start = sc.nextInt();
			for (int i = 0; i < n/2; i++) {
				int a = sc.nextInt(), b = sc.nextInt();
				nodes[a].list.add(b);
			}
			System.out.printf("#%d %d\n", t, bfs());
		}
	}
	static int bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visit[start] = true;
		int max = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			max = 0;
			while (size-- > 0) {
				int cur = q.poll();
				max = Math.max(max, cur);
				for (int i : nodes[cur].list) {
					if (!visit[i]) {
						q.add(i);
						visit[i] = true;
					}
				}
			}
		}
		return max;
	}
}