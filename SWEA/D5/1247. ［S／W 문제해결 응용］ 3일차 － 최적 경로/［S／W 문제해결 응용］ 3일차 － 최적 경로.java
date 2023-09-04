import java.io.*;
import java.util.*;

public class Solution {
	static int n, min;
	static int[][] pos;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t = 1; t <= tc; t++) {
			n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			pos = new int[n+2][2];
			for (int i = 0; i < n+2; i++) {
				pos[i][0] = Integer.parseInt(st.nextToken());
				pos[i][1] = Integer.parseInt(st.nextToken());
			}
			min = Integer.MAX_VALUE;
			check(2, 0, 0);
			System.out.printf("#%d %d\n", t, min);
		}
	}
	static void check(int cur, int prev, int sum) {
		if (sum > min) return;
		if (cur == n+2) {
			min = Math.min(min, sum+distance(prev, 1));
		}
		
		for (int idx = cur; idx < n+2; idx++) {
			swap(cur, idx);
			check(cur+1, cur, sum+distance(prev, cur));
			swap(cur, idx);
		}
	}
	static int distance(int i, int j) {
		return Math.abs(pos[i][0] - pos[j][0]) + Math.abs(pos[i][1] - pos[j][1]);
	}
	static void swap(int i, int j) {
		int[] tmp = pos[i];
		pos[i] = pos[j];
		pos[j] = tmp;
	}
}