import java.util.*;

public class Main {
    static int[] dist;

    public static void main(String[] args) {
        int INF = 20000 * 11;
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt(), E = sc.nextInt(), S = sc.nextInt();
        NodeList[] nodes = new NodeList[V+1];
        for (int i = 1; i <= V; i++) {
            nodes[i] = new NodeList();
        }
        for (int i = 0; i < E; i++) {
            int start = sc.nextInt(), end = sc.nextInt(), cost = sc.nextInt();
            nodes[start].list.add(new Node(end, cost));
        }
        dist = new int[V + 1];
        Arrays.fill(dist, INF);
        dist[S] = 0;
        boolean[] visited = new boolean[V + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(S));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (visited[cur.idx])
                continue;
            visited[cur.idx] = true;
            for (Node next : nodes[cur.idx].list) {
                if (next.cost + cur.cost < dist[next.idx]) {
                    dist[next.idx] = next.cost + cur.cost;
                    pq.add(new Node(next.idx));
                }
            }
        }
        for (int i = 1; i <= V; i++) {
            if (dist[i] >= INF)
                System.out.println("INF");
            else
                System.out.println(dist[i]);
        }
    }

    static class NodeList {
        List<Node> list = new ArrayList<>();
    }

    static class Node implements Comparable<Node> {
        int idx, cost;

        Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }

        Node(int idx) {
            this(idx, dist[idx]);
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
