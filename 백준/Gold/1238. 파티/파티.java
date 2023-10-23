import java.util.*;

public class Main {
	public static void main(String[] args) {
		int inf = 1 << 29;
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), e = sc.nextInt(), x = sc.nextInt();
		int[][] cost = new int[n+1][n+1];
		for (int i = 1; i <= n; i++) {
			Arrays.fill(cost[i], inf);
			cost[i][i] = 0;
		}
		for (int i = 0; i < e; i++) {
			int a = sc.nextInt(), b = sc.nextInt();
			cost[a][b] = sc.nextInt();
		}
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					cost[i][j] = Math.min(cost[i][k] + cost[k][j], cost[i][j]);
				}
			}
		}
		int max = 0;
		for (int i = 1; i <= n; i++) {
			max = Math.max(max, cost[i][x]+cost[x][i]);
		}
		System.out.println(max);
	}
}