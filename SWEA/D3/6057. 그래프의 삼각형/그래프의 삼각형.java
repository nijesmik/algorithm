import java.util.Scanner;

public class Solution {
	static boolean[][] graph;
	static int v, e;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			v = sc.nextInt();
			e = sc.nextInt();
			graph = new boolean[v+1][v+1];
			for (int i = 0; i < e; i++) {
				int a = sc.nextInt(), b = sc.nextInt();
				graph[a][b] = true;
				graph[b][a] = true;
			}
			System.out.printf("#%d %d\n", t, triangle());
		}
	}
	static int triangle() {
		int cnt = 0;
		for (int i = 1; i <= v; i++) {
			for (int j = i; j <= v; j++) {
				for (int k = j; k <= v; k++) {
					if (graph[i][j] && graph[i][k] && graph[k][j])
						cnt++;
				}
			}
		}
		return cnt;
	}
}