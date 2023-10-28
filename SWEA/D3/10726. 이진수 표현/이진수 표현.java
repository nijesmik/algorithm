import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for (int t = 1; t <= testcase; t++) {
			int bit = (1 << sc.nextInt()) - 1;
			int num = sc.nextInt();
			String ans = "OFF";
			if ((bit & num) == bit)
				ans = "ON";
			System.out.printf("#%d %s\n", t, ans);
		}
	}
}
