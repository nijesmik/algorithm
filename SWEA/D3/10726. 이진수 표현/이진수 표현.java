import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			int n = sc.nextInt(), m = sc.nextInt();
			int cmp = (int)Math.pow(2, n)-1;
			String ans;
			if ((m & cmp) == cmp) ans = "ON";
			else ans = "OFF";
			System.out.printf("#%d %s\n", t, ans);
		}
	}
}