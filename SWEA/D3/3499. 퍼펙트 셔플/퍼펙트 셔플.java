import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			String[] tmp = new String[n+1];
			tmp[n] = "";
			String ans = "";
			for (int i = 0; i < n; i++) tmp[i] = sc.next();
			for (int i = 0; i < (n+1)/2; i++) ans += " "+tmp[i]+" "+tmp[i+(n+1)/2];
			System.out.printf("#%d%s\n", t, ans);
		}
	}
}