import java.util.*;

public class Solution {
	static int[][] synergy;
	static int min, r, n;
	static boolean[] select;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			n = sc.nextInt();
			synergy = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++)
					synergy[i][j] = sc.nextInt();
			}
			r = n / 2;
			min = 20000 * r;
			select = new boolean[n];
			select[0] = true; // 중복 제거
			getAnswer(1, 1);
			System.out.printf("#%d %d\n", t, min);
		}
	}

	static void getAnswer(int idx, int sidx) {
		if (sidx == r) {
			min = Math.min(min, getSynergy());
			return;
		}
		if (idx == n)
			return;
		select[idx] = true;
		getAnswer(idx + 1, sidx + 1);
		select[idx] = false;
		getAnswer(idx + 1, sidx);
	}

	static int getSynergy() {
		int synergy1 = 0, synergy2 = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (select[i] && select[j]) synergy1 += synergy[i][j];
				if (!select[i] && !select[j]) synergy2 += synergy[i][j];
			}
		}
		return Math.abs(synergy1 - synergy2);
	}
}