import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			String[] pole = sc.next().split("");
			int total = 0;
			int cnt = 1;
			for (int i = 1; i < pole.length; i++) {
				if (pole[i].equals("(")) cnt++;
				else if (pole[i-1].equals("(")) total += --cnt;
				else { cnt--; total++; }
			}
			System.out.printf("#%d %d\n", t, total);
		}
	}
}