import java.util.*;

public class Main {
    static int sizeR, sizeC, map[][], ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sizeR = sc.nextInt();
        sizeC = sc.nextInt();
        map = new int[sizeR][sizeC];
        for (int i = 0; i < sizeR; i++) {
            for (int j = 0; j < sizeC; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < sizeR; i++) {
            for (int j = 0; j < sizeC; j++) {
                bfs(i, j);
            }
        }
        System.out.println(ans);
    }

    static int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 }, dc = { -1, 0, 1, -1, 1, -1, 0, 1 };

    static void bfs(int r, int c) {
        if (map[r][c] == 1) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(r, c));
        boolean[][] visited = new boolean[sizeR][sizeC];
        visited[r][c] = true;
        int dist = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Node cur = q.poll();
                for (int i = 0; i < 8; i++) {
                    int nr = cur.r + dr[i], nc = cur.c + dc[i];
                    if (nr < 0 || nr >= sizeR || nc < 0 || nc >= sizeC || visited[nr][nc]) {
                        continue;
                    }
                    if (map[nr][nc] == 1) {
                        ans = Math.max(ans, dist);
                        return;
                    }
                    visited[nr][nc] = true;
                    q.add(new Node(nr, nc));
                }
            }
            dist++;
        }
    }

    static class Node {
        int r, c;

        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}