import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.nextInt();
		for (int t = 1; t <= 10; t++) {
            sc.nextInt();
			int[] cnt = new int[101];
			int score_mode = 0;
			for (int i = 0; i < 1000; i++) {
				int score = sc.nextInt();
				cnt[score] += 1;
				if (cnt[score_mode] < cnt[score]) 
					score_mode = score;
				else if (cnt[score_mode] == cnt[score])
					score_mode = Math.max(score, score_mode);
			}
			System.out.printf("#%d %d\n", t, score_mode);
		}
	}
}