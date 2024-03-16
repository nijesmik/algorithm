import java.util.*;

public class Main {
	static int[] dr = { 1, -1, 0, 0 }, dc = { 0, 0, 1, -1 };
	static int N, map[][], id = 2;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		Map<Integer, boolean[][]> visitedMap = new HashMap<>();
		Queue<Record> q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0) {
					continue;
				}
				if (map[i][j] == 1) {
					dfs(i, j);
					id++;
				}
				for (int k = 0; k < 4; k++) {
					int nr = i + dr[k], nc = j + dc[k];
					boolean[][] visited = visitedMap.get(map[i][j]);
					if (visited == null) {
						visited = new boolean[N][N];
						visitedMap.put(map[i][j], visited);
					}
					if (isVisitable(nr, nc, visited) && map[nr][nc] == 0) {
						q.add(new Record(nr, nc, 1, map[i][j]));
						visited[nr][nc] = true;
					}
				}

			}
		}
		while (!q.isEmpty()) {
			Record cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i], nc = cur.c + dc[i];
				boolean[][] visited = visitedMap.get(cur.id);
				if (!isVisitable(nr, nc, visited)) {
					continue;
				} else if (map[nr][nc] == 0) {
					q.add(new Record(nr, nc, cur.dist + 1, cur.id));
					visited[nr][nc] = true;
				} else if (map[nr][nc] != cur.id) {
					System.out.println(cur.dist);
					return;
				}
			}
		}
	}

	static void dfs(int r, int c) {
		if (r >= 0 && r < N && c >= 0 && c < N && map[r][c] == 1) {
			map[r][c] = id;
			for (int i = 0; i < 4; i++) {
				dfs(r + dr[i], c + dc[i]);
			}
		}
	}

	static boolean isVisitable(int nr, int nc, boolean[][] visited) {
		return (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]);
	}

	static class Record {
		int r, c, dist, id;

		Record(int r, int c, int dist, int id) {
			this.r = r;
			this.c = c;
			this.dist = dist;
			this.id = id;
		}
	}
}