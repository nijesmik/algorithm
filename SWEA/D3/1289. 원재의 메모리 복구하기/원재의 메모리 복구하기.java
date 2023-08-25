import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int ans = 0;
			char tmp = '0';
			for (char c : sc.next().toCharArray()) {
				if (c != tmp) ans++;
				tmp = c;
			}
			System.out.printf("#%d %d\n", t, ans);
		}
	}
}