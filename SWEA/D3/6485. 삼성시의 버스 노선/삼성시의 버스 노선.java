import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			int[][] bus = new int[n][2];
			for (int i = 0; i < n; i++) {
				bus[i][0] = sc.nextInt();
				bus[i][1] = sc.nextInt(); 
			}
			int p = sc.nextInt();
			int[][] stop = new int[p][2];
			for (int i = 0; i < p; i++) stop[i][0] = sc.nextInt(); 
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < p; j++) {
					if (bus[i][0] <= stop[j][0] && stop[j][0] <= bus[i][1])
						stop[j][1] += 1;
				}
			}
			String ans = "#"+t;
			for (int[] arr : stop) ans += " "+arr[1];
			System.out.println(ans);
		}
		sc.close();
	}
}