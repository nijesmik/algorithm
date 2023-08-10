import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			sc.nextInt();
			int[][] board = new int[100][100];
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++)
					board[i][j] = sc.nextInt();
			}
			int ans = 0, sum1 = 0, sum2 = 0;
			for (int i = 0; i < 100; i++) {
				int sum3 = 0, sum4 = 0;
				for (int j = 0; j < 100; j++) {
					sum3 += board[i][j];
					sum4 += board[j][i];
					if (i == j) sum1 += board[i][j];
					if (i+j == 99) sum2 += board[i][j];
				}
				ans = Math.max(ans, Math.max(sum3, sum4));
			}
			System.out.printf("#%d %d\n", t, Math.max(ans, Math.max(sum1, sum2)));
		}
	}
}
