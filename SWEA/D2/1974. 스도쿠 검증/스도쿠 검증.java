import java.util.Scanner;

public class Solution {
	static int[][] map = new int[9][9];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			System.out.printf("#%d %d\n", t, check());
		}
	}
	static int check() {
		int sum1;
		int sum2;
		for (int i = 0; i < 9; i++) {
			sum1 = 0;
			sum2 = 0;
			for (int j = 0; j < 9; j++) {
				sum1 += map[i][j];
				sum2 += map[j][i];
			}
			if (sum1 != 45 || sum2 != 45) return 0;
		}
		int[][] arr = {
				{0,0},{0,3},{0,6},
				{3,0},{3,3},{3,6},
				{6,0},{6,3},{6,6}
		};
		for (int[] pos : arr) {
			sum1 = 0;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) 
					sum1 += map[pos[0] + i][pos[1] + j];
			}
			if (sum1 != 45) return 0;
		}
		return 1;
	}
}
