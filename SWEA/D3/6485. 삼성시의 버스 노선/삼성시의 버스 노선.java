import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			int[][] buses = new int[n][2];
			for (int[] bus : buses) {
				bus[0] = sc.nextInt();
				bus[1] = sc.nextInt(); 
			}
			int p = sc.nextInt();
			int[][] stops = new int[p][2];
			for (int i = 0; i < p; i++) stops[i][0] = sc.nextInt(); 
			for (int[] stop : stops) {
				for (int[] bus : buses) {
					if (bus[0] <= stop[0] && stop[0] <= bus[1])
						stop[1] += 1;
				}
			}
			String ans = "#"+t;
			for (int[] stop : stops) ans += " "+stop[1];
			System.out.println(ans);
		}
		sc.close();
	}
}