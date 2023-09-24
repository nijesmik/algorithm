import java.util.*;

public class Solution {
	static class Node {
		int degree;
		List<Integer> next = new ArrayList<>();
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t < 11; t++) {
			sb.append("#"+t+" ");
			int v = sc.nextInt(), e = sc.nextInt();
			Node[] nodes = new Node[v+1];
			for (int i = 0; i <= v; i++) {
				nodes[i] = new Node();
			}
			for (int i = 0; i < e; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				nodes[a].next.add(b);
				nodes[b].degree += 1;
			}
			Queue<Integer> q = new LinkedList<>();
			for (int i = 1; i <= v; i++) {
				if (nodes[i].degree == 0) q.add(i);
			}
			while (!q.isEmpty()) {
				int idx = q.poll();
				sb.append(idx+" ");
				for (int i : nodes[idx].next) {
					nodes[i].degree -= 1;
					if (nodes[i].degree == 0) q.add(i);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}