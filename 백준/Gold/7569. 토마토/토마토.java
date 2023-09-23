import java.io.*;
import java.util.*;

public class Main {
	static int cLen, rLen, hLen;
	static int[][][] tomato;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		cLen = Integer.parseInt(st.nextToken());
		rLen = Integer.parseInt(st.nextToken());		
		hLen = Integer.parseInt(st.nextToken());		
		tomato = new int[hLen][rLen][cLen];
		for (int i = 0; i < hLen; i++) {
			for (int j = 0; j < rLen; j++) {
				int k = 0;
				for (String str : br.readLine().split(" ")) {
					tomato[i][j][k++] = Integer.parseInt(str);
				}
			}
		}
		for (int i = 0; i < hLen; i++) {
			for (int j = 0; j < rLen; j++) {
				for (int k = 0; k < cLen; k++) {
					if (tomato[i][j][k] == 1) {
						bfs(i, j, k);
					}
				}
			}
		}
		System.out.println(check());
	}
	static int[] dh = {1, -1, 0, 0, 0, 0};
	static int[] dr = {0, 0, 1, -1, 0, 0};
	static int[] dc = {0, 0, 0, 0, 1, -1};
	static void bfs(int h, int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{h, r, c});
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int day = tomato[cur[0]][cur[1]][cur[2]];
			for (int i = 0; i < 6; i++) {
				int nh = cur[0]+dh[i], nr = cur[1]+dr[i], nc = cur[2]+dc[i];
				if (nh < 0 || nh >= hLen || nr < 0 || nr >= rLen || nc < 0 || nc >= cLen)
					continue;
				if (tomato[nh][nr][nc] == 0 || tomato[nh][nr][nc] > day + 1) {
					tomato[nh][nr][nc] = day + 1;
					q.add(new int[]{nh, nr, nc});
				}
			}
		}
	}
	static int check() {
		int max = 0;
		for (int i = 0; i < hLen; i++) {
			for (int j = 0; j < rLen; j++) {
				for (int k = 0; k < cLen; k++) {
					int t = tomato[i][j][k];
					if (t == 0) return -1;
					max = Math.max(max, t);
				}
			}
		}
		return max-1;
	}
}