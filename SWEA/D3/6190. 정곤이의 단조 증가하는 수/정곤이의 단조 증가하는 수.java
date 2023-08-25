import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
			int max = -1;
			for (int i = 0; i < n; i++) {
				for (int j = i+1; j < n; j++) {
					int num = arr[i]*arr[j];
					if (isDanzo(num)) max = Math.max(max, num);
				}
			}
			System.out.printf("#%d %d\n", t, max);
		}
	}
	static boolean isDanzo(int num) {
		while (num > 9) {
			int one = num % 10;
			num /= 10;
			int ten = num % 10;
			if (one < ten) return false;
		}
		return true;
	}
}