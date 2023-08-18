import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt(), m = sc.nextInt();
			int[] cnt = new int[n+m+1];
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= m; j++) cnt[i+j] += 1;
			}
			LinkedList<Integer> queue = new LinkedList<>();
			for (int i = 1; i <= n+m; i++) {
				if (!queue.isEmpty() && cnt[queue.peek()] > cnt[i]) continue;
				while (!queue.isEmpty() && cnt[queue.peek()] < cnt[i]) queue.poll();
				queue.offer(i);
			}
			String str = "";
			for (int i : queue) str += " "+i;
			System.out.printf("#%d%s\n", t, str);
		}
	}
}