import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			sc.nextInt();
			System.out.printf("#%d %d\n", t, power(sc.nextInt(), sc.nextInt()));
		}
	}
	static int power(int n, int m) {
		if (m == 0) return 1;
		return n * power(n, m-1);
	}
}