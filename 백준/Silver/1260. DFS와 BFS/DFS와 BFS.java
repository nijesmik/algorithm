import java.util.*;

public class Main {
    static Node[] nodes;
    static boolean[] visited;
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), e = sc.nextInt(), start = sc.nextInt();

        nodes = new Node[n + 1];
        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node();
        }

        while (e-- > 0) {
            int a = sc.nextInt(), b = sc.nextInt();
            nodes[a].next.add(b);
            nodes[b].next.add(a);
        }

        for (int i = 1; i <= n; i++) {
            nodes[i].next.sort(Comparator.naturalOrder());
        }

        sb = new StringBuilder();
        visited = new boolean[n + 1];
        dfs(start);

        sb.append('\n');
        visited = new boolean[n + 1];
        bfs(start);

        System.out.println(sb);
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.add(start);
        while (!q.isEmpty()) {
            int cur = q.poll();
            sb.append(cur).append(' ');
            for (int i : nodes[cur].next) {
                if (!visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }

    static void dfs(int cur) {
        if (!visited[cur]) {
            visited[cur] = true;
            sb.append(cur).append(' ');
            for (int i : nodes[cur].next) {
                dfs(i);
            }
        }
    }

    static class Node {
        List<Integer> next = new ArrayList<>();
    }
}