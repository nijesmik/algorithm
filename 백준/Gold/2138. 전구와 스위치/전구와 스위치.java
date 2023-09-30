import java.util.Scanner;

public class Main {
	static int n, ans;
	static char[] before1, before2, after;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		before1 = sc.next().toCharArray();
		before2 = new char[n];
		for (int i = 0; i < n; i++) {
			before2[i] = before1[i];
		}
		after = sc.next().toCharArray();
		ans = check(before1, 0);
		if (ans < 0) {
			flip(before2, -1);
			ans = check(before2, 1);
		}
		System.out.println(ans);
	}
	static int check(char[] before, int cnt) {
		for (int i = 0; i < n-1; i++) {
			if (before[i] == after[i]) continue;
			flip(before, i);
			cnt++;
		}
		if (before[n-1] != after[n-1]) return -1;
		return cnt;
	}
	static void flip(char[] before, int idx) {
		for (int i = idx; i < idx+3; i++) {
			if (i < 0 || i >= n) continue;
			before[i] = before[i] == '0' ? '1' : '0';
		}
	}
}