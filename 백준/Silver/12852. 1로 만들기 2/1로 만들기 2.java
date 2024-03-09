import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] dp = new int[1000001];
		dp[2] = 1;
		dp[3] = 1;
		for (int i = 4; i <= n; i++) {
			dp[i] = dp[i - 1];
			if (i % 2 == 0) {
				dp[i] = Math.min(dp[i], dp[i / 2]);
			}
			if (i % 3 == 0) {
				dp[i] = Math.min(dp[i], dp[i / 3]);
			}
			dp[i]++;
		}
		StringBuilder sb = new StringBuilder();
		sb.append(dp[n]).append('\n');
		while (n > 0) {
			sb.append(n).append(' ');
			int next = n - 1;
			if (n % 2 == 0 && dp[next] > dp[n / 2]) {
				next = n / 2;
			}
			if (n % 3 == 0 && dp[next] > dp[n / 3]) {
				next = n / 3;
			}
			n = next;
		}
		System.out.println(sb);
	}
}
