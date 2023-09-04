import java.util.Scanner;

public class Solution {
	static int n, b, ans;
	static int[] height;
	static boolean[] visit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			n = sc.nextInt(); b = sc.nextInt();
			ans = Integer.MAX_VALUE;
			height = new int[n];
			visit = new boolean[n];
			for (int i = 0; i <n; i++) height[i] = sc.nextInt();
			check(0);
			System.out.printf("#%d %d\n", t, ans);
		}
	}
	static void check(int idx) {
		if (ans == 0) return;
		if (idx == n) {
			int tmp = 0;
			for (int i = 0; i < n; i++) {
				if (visit[i]) tmp += height[i];
			}
			if (tmp < b) return;
			ans = Math.min(ans, tmp-b);
			return;
		}
		visit[idx] = true;
		check(idx+1);
		visit[idx] = false;
		check(idx+1);
	}
}