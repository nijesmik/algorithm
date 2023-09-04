import java.util.Scanner;

public class Solution {
	static int[][] film, tmp;
	static int[] a, b;
	static int d, w, k, ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			d = sc.nextInt(); w = sc.nextInt(); k = sc.nextInt();
			film = new int[d][w];
			tmp = new int[d][];
			for (int[] row : film) {
				for (int i = 0; i < w; i++)
					row[i] = sc.nextInt();
			}
			a = new int[w];
			b = new int[w];
			for (int i = 0; i < w; i++) b[i] = 1;
			ans = Integer.MAX_VALUE;
			check(0, 0);
			System.out.printf("#%d %d\n", t, ans);
		}
	}
	static void check(int idx, int injection) {
		if (injection >= ans) return;
		if (idx == d) {
			if (isValidFilm()) ans = Math.min(ans, injection);
			return;
		}
		tmp[idx] = film[idx];
		check(idx+1, injection);
		tmp[idx] = a;
		check(idx+1, injection+1);
		tmp[idx] = b;
		check(idx+1, injection+1);
	}
	static boolean isValidFilm() {
		for (int i = 0; i < w; i++) {
			int cnt = 1, prev = tmp[0][i];
			for (int j = 1; j < d; j++) {
				if (tmp[j][i] == prev) cnt++;
				else {
					cnt = 1;
					prev = tmp[j][i];
				}
				if (cnt >= k) break;
			}
			if (cnt < k) return false;
		}
		return true;
	}
}