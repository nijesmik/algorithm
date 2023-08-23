import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		HashMap<Integer, LinkedList<Integer>> graph = new HashMap<>();
		for (int i = 1; i <= n; i++) graph.put(i, new LinkedList<>());
		for (int i = 0; i < n-1; i++) {
			int a = sc.nextInt(), b = sc.nextInt();
			graph.get(a).add(b); graph.get(b).add(a);
		}
		int[] ans = new int[n+1];
		LinkedList<Integer> queue = new LinkedList<>();
		queue.add(1);
		while (!queue.isEmpty()) {
			int parent = queue.poll();
			for (int child : graph.get(parent)) {
				if (ans[child] > 0) continue;
				ans[child] = parent;
				queue.add(child);
			}
		}
		for (int i = 2; i <= n; i++) System.out.println(ans[i]);
	}
}