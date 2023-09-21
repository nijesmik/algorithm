import java.util.*;

public class Main {
	static class Node {
		List<int[]> next = new ArrayList<>();
	}
	static Node[] tree;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		tree = new Node[n+1];
		for (int i = 1; i <= n; i++) {
			tree[i] = new Node();
		}
		for (int i = 0; i < n-1; i++) {
			int a = sc.nextInt(), b = sc.nextInt();
			int len = sc.nextInt();
			tree[a].next.add(new int[]{b, len});
			tree[b].next.add(new int[]{a, len});
		}
		max = 0; idx = 1;
		dfs(0, 1, 0);
		dfs(0, idx, 0);
		System.out.println(max);
	}
	static int max, idx;
	static void dfs(int prev, int cur, int len) {
		if (len > max) {
			max = len;
			idx = cur;
		}
		for (int[] next : tree[cur].next) {
			if (next[0] != prev)
				dfs(cur, next[0], len+next[1]);
		}
	}
}