import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			int n = sc.nextInt(), limit = sc.nextInt();
			int[] calorie = new int[n];
			int[] score = new int[n];
			for (int i = 0; i < n; i++) {
				score[i] = sc.nextInt();
				calorie[i] = sc.nextInt();
			}
			int max = 0;
			for (int i = 0; i < 1 << n; i++) {
				int ssum = 0, csum = 0;
				for (int j = 0; j < n; j++) {
					if ((i & (1 << j)) > 0) {
						ssum += score[j];
						csum += calorie[j];
					}
				}
				if (csum <= limit) max = Math.max(max, ssum);
			}
			System.out.printf("#%d %d\n", t, max);
		}
	}
}