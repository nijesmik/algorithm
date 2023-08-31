import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			int n = sc.nextInt(), k = sc.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			int ans = 0;
			for (int i = 0; i < 1 << n; i++) {
				int sum = 0;
				for (int j = 0; j < n; j++) {
					if ((i & (1 << j)) > 0) sum += arr[j];
				}
				if (sum == k) ans++;
			}
			System.out.printf("#%d %d\n", t, ans);
		}
	}
}