import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for (int t = 1; t <= testcase; t++) {
			int n = sc.nextInt();
			int visit = 0;
			int ans = 0;
			while (visit != (1 << 10) - 1) {
				ans += n;
				int number = ans;
				while (number > 0) {
					int bit = number % 10;
					number /= 10;
					visit = visit | 1 << bit;
				}
			}
			System.out.printf("#%d %d\n", t, ans);
		}
	}
}
