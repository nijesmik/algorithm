import java.util.*;

public class Main {
    static int[] nodes;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), e = sc.nextInt();
        nodes = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            nodes[i] = i;
        }
        for (int i = 0; i < e; i++) {
            union(sc.nextInt(), sc.nextInt());
        }
        Set<Integer> parents = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            parents.add(parent(i));
        }
        System.out.println(parents.size());
    }

    static int parent(int a) {
        if (nodes[a] != a) {
            nodes[a] = parent(nodes[a]);
        }
        return nodes[a];
    }

    static void union(int a, int b) {
        nodes[parent(b)] = parent(a);
    }
}