import java.util.Scanner;

public class Solution {
	static int[] price, plan;
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			price = new int[4];
			plan = new int[12];
			for (int i = 0; i < 4; i++) {
				price[i] = sc.nextInt();
			}
			for (int i = 0; i < 12; i++) {
				plan[i] = sc.nextInt();
			}
			ans = price[3];
			combination(0, 0);
			System.out.printf("#%d %d\n", t, ans);
		}
	}
	static void combination(int idx, int cost) {
		if (idx>11) {
			ans = Math.min(ans, cost);
			return;
		}
		int min = Math.min(price[0]*plan[idx], price[1]);
		combination(idx+1, cost+min);
		combination(idx+3, cost+price[2]);
	}
}