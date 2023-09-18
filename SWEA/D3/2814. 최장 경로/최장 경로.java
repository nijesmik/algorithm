import java.util.Scanner;

public class Solution {
	static int v;
	static boolean[][] graph;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			v = sc.nextInt();
			int e = sc.nextInt();
			graph = new boolean[v+1][v+1];
			for (int i = 1; i <= v; i++) {
				graph[0][i] = true;}
			for (int i = 0; i < e; i++) {
				int a = sc.nextInt(), b = sc.nextInt();
				graph[a][b] = true;
				graph[b][a] = true;
			}
			System.out.printf("#%d %d\n", t, dfs(0, 0, 0));
		}
	}
	static int dfs(int cur, int visit, int cnt) {
		int result = cnt;
		for (int i = 1; i <= v; i++) {
			if ((visit >> i & 1) == 0 && graph[cur][i])
				result = Math.max(result, dfs(i, visit | 1 << i, cnt+1));
		}
		return result;
	}
}