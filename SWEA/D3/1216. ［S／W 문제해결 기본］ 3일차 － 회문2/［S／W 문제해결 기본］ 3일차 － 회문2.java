import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			sc.nextInt();
			int ans = 0;
			String[] board = new String[100];
			for (int i = 0; i < 100; i++) {
				board[i] = sc.next();
				for (int start = 0; start < 100; start++) {
					for (int end = start; end <= 100; end++) {
						ans = Math.max(ans, isPalindrome(board[i].substring(start, end)));
					}
				}
			}
			for (int i = 0; i < 100; i++) {
				String col = "";
				for (int j = 0; j < 100; j++) col += board[j].charAt(i);
				for (int start = 0; start < 100; start++) {
					for (int end = start; end <= 100; end++)
						ans = Math.max(ans, isPalindrome(col.substring(start, end)));
				}
			}
			System.out.printf("#%d %d\n", t, ans);
		}
	}

	static int isPalindrome(String str) {
		int len = str.length();
		for (int i = 0; i < len / 2; i++) {
			if (str.charAt(i) != str.charAt(len-i-1)) {
				return 0;
			}
		}
		return len;
	}
}
