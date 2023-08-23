import java.util.*;

public class Solution {
	static int[][] tree;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int v = sc.nextInt(), e = sc.nextInt();
			int a = sc.nextInt(), b = sc.nextInt();
			tree = new int[v+1][3];
			for (int i = 0; i < e; i++) {
				int parent = sc.nextInt(), child = sc.nextInt();
				if (tree[parent][0] > 0) tree[parent][1] = child;
				else tree[parent][0] = child;
				tree[child][2] = parent;
			}
			int ancestor = getAncestor(a, b);
			System.out.printf("#%d %d %d\n", t, ancestor, getSize(ancestor));
		}
	}

	static int getSize(int idx) {
		if (idx == 0) return 0;
		return getSize(tree[idx][0]) + getSize(tree[idx][1]) + 1;
	}

	static int getAncestor(int a, int b) {
		int num = a;
		ArrayList<Integer> list = new ArrayList<>();
		while (num > 1) {
			int p = tree[num][2];
			list.add(p);
			num = p;
		}
		num = b;
		while (num > 1) {
			int p = tree[num][2];
			for (int e : list) {
				if (e == p) return p;
			}
			num = p;
		}
		return 1;
	}
}