import java.util.Scanner;

public class Solution {
	static int n, b, ans;
	static int[] height;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			n = sc.nextInt(); b = sc.nextInt();
			ans = Integer.MAX_VALUE;
			height = new int[n];
			for (int i = 0; i <n; i++) height[i] = sc.nextInt();
			check(0, 0);
			System.out.printf("#%d %d\n", t, ans);
		}
	}
	static void check(int idx, int sum) {
		if (ans == 0) return;
		if (idx == n) {
			if (sum >= b) ans = Math.min(ans, sum-b);
			return;
		}
		check(idx+1, sum+height[idx]);
		check(idx+1, sum);
	}
}