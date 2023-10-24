import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];
		boolean[][] dp = new boolean[n+1][n+1];
		String[] input = br.readLine().split(" ");
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(input[i-1]);
			dp[i][i] = true;
			if (arr[i] == arr[i-1]) dp[i-1][i] = true;
		}
		for (int i = n; i > 0; i--) {
			for (int j = i+1; j <= n; j++) {
				if (arr[i] == arr[j] && dp[i+1][j-1]) dp[i][j] = true;
			}
		}
		int m = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			input = br.readLine().split(" ");
			int ans = dp[Integer.parseInt(input[0])][Integer.parseInt(input[1])] ? 1 : 0;
			sb.append(ans+"\n");
		}
		System.out.println(sb);
	}
}