import java.util.Scanner;

public class Solution {
	static int n;
    static char[] data;
	static String ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			n = Integer.parseInt(sc.nextLine());
			data = new char[n+1];
			for (int i = 1; i <= n; i++) {
				String[] tmp = sc.nextLine().split(" ");
				data[i] = tmp[1].charAt(0);
			}
			ans = "";
			getAns(1);
			System.out.printf("#%d %s\n", t, ans);
		}
	}
	static void getAns(int idx) {
		if (idx > n) return ;
		getAns(idx*2);
		ans += data[idx];
		getAns(idx*2+1);
	}
}