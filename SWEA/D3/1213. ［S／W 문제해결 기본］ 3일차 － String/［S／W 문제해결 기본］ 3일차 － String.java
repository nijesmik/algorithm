import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			sc.nextInt();
			String search = sc.next();
			String str = sc.next();
			int ans = 0;
			for (int i = 0; i < str.length(); i++) {
				if (str.startsWith(search, i)) ans += 1;
			}
			System.out.printf("#%d %d\n", t, ans);
		}
	}
}