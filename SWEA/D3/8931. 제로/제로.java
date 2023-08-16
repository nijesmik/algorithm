import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int K = sc.nextInt();
			int[] arr = new int[K];
			int cur = 0;
			for (int k = 0; k < K; k++) {
				int tmp = sc.nextInt();
				if (tmp == 0) cur--;
				else arr[cur++] = tmp;
			}
			int sum = 0;
			for (int i = 0; i < cur; i++) sum += arr[i];
			System.out.printf("#%d %d\n", t, sum);
		}
	}
}