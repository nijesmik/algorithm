import java.util.*;

public class Solution {
	static int[] rep;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			int n = sc.nextInt(), m = sc.nextInt();
			rep = new int[n+1];
			for (int i = 0; i <= n; i++) {
				rep[i] = i;
			}
			for (int i = 0; i < m; i++) {
				union(sc.nextInt(), sc.nextInt());
			}
			Set<Integer> set = new HashSet<>();
			for (int i = 1; i <= n; i++) {
				set.add(findSet(i));
			}
			System.out.printf("#%d %d\n", t, set.size());
		}
	}
	static int findSet(int idx) {
		if (idx != rep[idx])
			rep[idx] = findSet(rep[idx]);
		return rep[idx];
	}
	static void union(int a, int b) {
		rep[findSet(a)] = findSet(b);
	}
}