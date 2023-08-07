import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] dx = {-2, -1, 1, 2};
		for (int t = 1; t <= 10; t++) {
			int ans = 0;
			int n = sc.nextInt();
			int[] building = new int[n+4];
			for (int i = 2; i < n+2; i++) building[i] = sc.nextInt();
			for (int i = 2; i < n+2; i++) {
				int[] view = new int[4];
				int idx = 0;
				for (int d : dx)
					view[idx++] = Math.max(building[i] - building[i+d], 0);
				Arrays.sort(view);
				ans += view[0];
			}
			System.out.printf("#%d %d\n", t, ans);
		}
	}
}
