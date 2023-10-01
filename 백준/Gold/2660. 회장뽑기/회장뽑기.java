import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] graph = new int[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(graph[i], 100);
			graph[i][i] = 0;
		}
		while (true) {
			int a = sc.nextInt() - 1;
			if (a < 0) break;
			int b = sc.nextInt() - 1;
			graph[a][b] = 1;
			graph[b][a] = 1;
		}
		for (int i = 0; i < n; i++) {
			for (int a = 0; a < n; a++) {
				for (int b = 0; b < n; b++) {
					int tmp = graph[a][i] + graph[i][b];
					graph[a][b] = Math.min(tmp, graph[a][b]);
				}
			}
		}
		int[] max = new int[n];
		int min = 100;
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				max[i] = Math.max(max[i], graph[i][j]);
			}
			if (max[i] < min) {
				list = new ArrayList<>();
				list.add(i);
				min = max[i];
			} else if (max[i] == min) {
				list.add(i);
			}
		}
		System.out.printf("%d %d\n", min, list.size());
		for (int i : list) {
			System.out.print(++i+" ");
		}
	}
}