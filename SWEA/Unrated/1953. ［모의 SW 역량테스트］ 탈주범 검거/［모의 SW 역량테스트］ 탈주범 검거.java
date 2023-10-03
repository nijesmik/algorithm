import java.util.*;

public class Solution {
	static int[][] pipe;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		pipe = new int[8][];
		pipe[1] = new int[]{0,1,2,3};
		pipe[2] = new int[]{0,1};
		pipe[3] = new int[]{2,3};
		pipe[4] = new int[]{0,3};
		pipe[5] = new int[]{1,3};
		pipe[6] = new int[]{1,2};
		pipe[7] = new int[]{0,2};
		for (int t = 1; t <= testcase; t++) {
			int sizeR = sc.nextInt(), sizeC = sc.nextInt();
			int startR = sc.nextInt(), startC = sc.nextInt(), time = sc.nextInt();
			int[][] map = new int[sizeR][sizeC];
			for (int i = 0; i < sizeR; i++) {
				for (int j = 0; j < sizeC; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			boolean[][] visit = new boolean[sizeR][sizeC];
			Queue<int[]> q = new LinkedList<>();
			q.add(new int[]{startR, startC});
			visit[startR][startC] = true;
			int ans = 0;
			for (int i = 0; i < time; i++) {
				int size = q.size();
				ans += size;
				for (int j = 0; j < size; j++) {
					int[] cur = q.poll();
					int r = cur[0], c = cur[1];
					for (int dirIndex : pipe[map[r][c]]) {
						int nr = r+dr[dirIndex], nc = c+dc[dirIndex];
						if (nr < 0 || nr >= sizeR || nc < 0 || nc >= sizeC || !check(dirIndex, map[nr][nc]) || visit[nr][nc])
							continue;
						q.add(new int[]{nr, nc});
						visit[nr][nc] = true;
					}
				}
			}
			System.out.printf("#%d %d\n", t, ans);
		}
	}
	static boolean check(int dirIndex, int pipeNum) {
		if (pipeNum == 0) return false;
		int cmp;
		if (dirIndex == 0) cmp = 1;
		else if (dirIndex == 1) cmp = 0;
		else if (dirIndex == 2) cmp = 3;
		else cmp = 2;
		for (int pipeDirIndex : pipe[pipeNum]) {
			if (pipeDirIndex == cmp) return true;
		}
		return false;
	}
}