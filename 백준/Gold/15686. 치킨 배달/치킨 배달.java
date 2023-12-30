import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N, M, C, ans;
    static Node[] chicken;
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); M = sc.nextInt(); C = 0;
        map = new int[N][N];
        chicken = new Node[13];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int type = sc.nextInt();
                map[i][j] = type;
                if (type == 2) {
                    chicken[C++] = new Node(i, j);
                }
            }
        }
        ans = Integer.MAX_VALUE;
        dfs(0, 0, 0);
        System.out.println(ans);
    }

    static int[] dr = {1, -1, 0, 0}, dc = {0, 0, 1, -1};
    static void bfs(int visit) {
        boolean[][] visited = new boolean[N][N];
        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i < C; i++) {
            if ((visit >> i & 1) == 1) {
                Node node = chicken[i];
                q.add(new Node(node.r, node.c, node));
                visited[node.r][node.c] = true;
            }
        }
        int total = 0;
        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i], nc = cur.c + dc[i];
                if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    if (map[nr][nc] == 1) {
                        total += dist(cur.start, nr, nc);
                    }
                    q.add(new Node(nr, nc, cur.start));
                }
            }
        }
        ans = Math.min(total, ans);
    }

    static int dist(Node node, int r, int c) {
        return Math.abs(node.r - r) + Math.abs(node.c - c);
    }

    static void dfs(int idx, int visit, int cnt) {
        if (idx > C) return;
        if (cnt == M) {
            bfs(visit);
            return;
        }

        dfs(idx+1, visit | 1 << idx, cnt+1);
        dfs(idx+1, visit, cnt);
    }

    static class Node {
        int r, c;
        Node start;
        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
        Node(int r, int c, Node node) {
            this(r, c);
            start = node;
        }
    }
}