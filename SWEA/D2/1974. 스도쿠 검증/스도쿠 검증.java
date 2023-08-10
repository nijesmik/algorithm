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
		for (int i = 0; i < 9; i++) {
			int[] arr1 = new int[9];
			int[] arr2 = new int[9];
			for (int j = 0; j < 9; j++) {
				arr1[map[i][j]-1] += 1;
				arr2[map[j][i]-1] += 1;
			}
			for (int j = 0; j < 9; j++) {
				if (arr1[j] != 1 || arr2[j] != 1) return 0;
			}
		}
		int[][] box = {
				{0,0},{0,3},{0,6},
				{3,0},{3,3},{3,6},
				{6,0},{6,3},{6,6}
		};
		for (int[] pos : box) {
			int[] arr3 = new int[9];
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++)
					arr3[map[pos[0] + i][pos[1] + j]-1] += 1;
			}
			for (int i = 0; i < 9; i++) {
				if (arr3[i] != 1) return 0;
			}
		}
		return 1;
	}
}