import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), k = sc.nextInt();
		int[] dx = {-1, 1, 0};
		int[] cnt = new int[100001];
		LinkedList<Integer> queue = new LinkedList<>();
		queue.offer(n);
		while (queue.peek() != k) {
			int cur = queue.poll();
			dx[2] = cur;
			for (int i = 0; i < 3; i++) {
				if (cur + dx[i] >= 0) {
					int next = cur + dx[i];
					if (next < 0 || next > 100000 || cnt[next] > 0) continue;
					cnt[next] = cnt[cur] + 1;
					queue.offer(next);
				}
			}
		}
		System.out.println(cnt[k]);
	}
}