import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] months = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};
		for (int t = 1; t <= T; t++) {
			int month1 = sc.nextInt(), day = sc.nextInt(), month2 = sc.nextInt(), ans = sc.nextInt();
			for (int i = 0; i < month2; i++) ans += months[i];
			for (int i = 0; i < month1; i++) ans -= months[i];
			System.out.printf("#%d %d\n", t, ans - day + 1);
		}
	}
}