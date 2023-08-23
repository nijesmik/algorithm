import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			int[] stops = new int[5001];
			for (int i = 0; i < n; i++) {
				for (int a = sc.nextInt(), b = sc.nextInt(); a <= b; a++)
					stops[a]++;
			}
			int p = sc.nextInt();
			String ans = "#"+t;
			for (int i = 0; i < p; i++) ans += " "+stops[sc.nextInt()];
			System.out.println(ans);
		}
	}
}