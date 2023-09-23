import java.io.*;
import java.util.*;

public class Main {
	static int cLen, rLen, hLen, cnt;
	static Queue<int[]> q;
	static int[][][] tomato;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		cLen = Integer.parseInt(st.nextToken());
		rLen = Integer.parseInt(st.nextToken());
		hLen = Integer.parseInt(st.nextToken());
		tomato = new int[hLen][rLen][cLen];
		q = new LinkedList<>();
		for (int i = 0; i < hLen; i++) {
			for (int j = 0; j < rLen; j++) {
				int k = 0;
				for (String str : br.readLine().split(" ")) {
					int num = Integer.parseInt(str);
					tomato[i][j][k] = num;
					if (num == 1) q.add(new int[]{i, j, k});
					else if (num == 0) cnt++;
					k++;
				}
			}
		}
		System.out.println(bfs());
	}
	static int[] dh = {1, -1, 0, 0, 0, 0};
	static int[] dr = {0, 0, 1, -1, 0, 0};
	static int[] dc = {0, 0, 0, 0, 1, -1};
	static int bfs() {
		int day = -1;
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				int[] cur = q.poll();
				for (int i = 0; i < 6; i++) {
					int nh = cur[0]+dh[i], nr = cur[1]+dr[i], nc = cur[2]+dc[i];
					if (nh < 0 || nh >= hLen || nr < 0 || nr >= rLen || nc < 0 || nc >= cLen)
					continue;
					if (tomato[nh][nr][nc] == 0) {
						tomato[nh][nr][nc] = tomato[cur[0]][cur[1]][cur[2]] + 1;
						q.add(new int[]{nh, nr, nc});
						cnt--;
					}
				}
			}
			day++;
		}
		return cnt > 0 ? -1 : day;
	}
}