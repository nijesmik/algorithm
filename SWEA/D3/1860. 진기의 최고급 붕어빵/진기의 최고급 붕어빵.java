import java.util.Arrays;
import java.util.Scanner;

class Solution {
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt(), m = sc.nextInt(), k = sc.nextInt();
			arr = new int[n];
			for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
			Arrays.sort(arr);
			System.out.printf("#%d %s\n", t, check(n, m, k));
		}
		sc.close();
	}
	static String check(int n, int m, int k) {
		int bread = 0;
		int cur = 0;
		for (int i = m; cur < n ; i += m) {
			while (cur < n && i > arr[cur]) {
				if (bread == 0)
					return "Impossible";
				bread--;
				cur++;
			}
			bread += k;
		}
		return "Possible";
	}
}