import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int start = sc.nextInt(), end = sc.nextInt();
		int[] dp = new int[100001];
		for (int i = start-1; i >= 0; i--) {
			dp[i] = dp[i+1] + 1;
		}
		for (int i = start+1; i <= end; i++) {
			int tmp = i%2 == 0 ? dp[i/2] : dp[(i+1)/2]+1;
			dp[i] = Math.min(dp[i-1]+1, tmp);
		}
		System.out.println(dp[end]);
	}
}