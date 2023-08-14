import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			String str = sc.next();
			int len = str.length(), ans = 1;
			for (int i = 0; i < len / 2; i++) {
				if (str.charAt(i) != str.charAt(len-i-1)) {
					ans = 0;
					break;
				}
			}
			System.out.printf("#%d %d\n", t, ans);
		}
	}
}