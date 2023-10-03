import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t < 11; t++) {
			sc.nextInt();
			int[][] map = new int[16][16];
			int startR = -1, startC = -1, endR = -1, endC = -1;
			for (int i = 0; i < 16; i++) {
				String str = sc.next();
				for (int j = 0; j < 16; j++) {
					char c = str.charAt(j);
					if (c == '1') continue;
					map[i][j] = 1;
					if (c == '2') {
						startR = i; startC = j;
					} else if (c == '3') {
						endR = i; endC = j;
					}
				}
			}
			int[] dr = {1, -1, 0, 0};
			int[] dc = {0, 0, 1, -1};
			Queue<int[]> q = new LinkedList<>();
			q.add(new int[]{startR, startC});
			while (!q.isEmpty()) {
				int[] cur = q.poll();
				for (int i = 0; i < 4; i++) {
					int nr = cur[0]+dr[i], nc = cur[1]+dc[i];
					if (nr < 0 || nr >= 16 || nc < 0 || nc >= 16) continue;
					if (map[nr][nc] == 1) {
						q.add(new int[]{nr, nc});
						map[nr][nc] = 1 + map[cur[0]][cur[1]];
					}
				}
			}
			int ans = map[endR][endC] > 1 ? 1 : 0;
			System.out.printf("#%d %d\n", t, ans);
		}
	}
}