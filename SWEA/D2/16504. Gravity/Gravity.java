import java.io.File;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for (int j = 0; j < n; j++) arr[j] = sc.nextInt();
			int ans = 0;
			for (int j = 0; j < n; j++) {
				int cnt = 0;
				for (int k = j+1; k < n; k++)
					if (arr[j] > arr[k]) cnt++;
				ans = Math.max(cnt, ans);
			}
			System.out.printf("#%d %d\n", i, ans);
		}
	}
}
