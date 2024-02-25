
import java.util.*;

public class Main {
    static int sizeR, sizeC, map[][], ans;
    static List<Node> sharks;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sizeR = sc.nextInt();
        sizeC = sc.nextInt();
        map = new int[sizeR][sizeC];
        sharks = new ArrayList<>();
        for (int i = 0; i < sizeR; i++) {
            for (int j = 0; j < sizeC; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 1) {
                    sharks.add(new Node(i, j));
                }
            }
        }
        for (int i = 0; i < sizeR; i++) {
            for (int j = 0; j < sizeC; j++) {
                if (map[i][j] == 0) {
                    getDist(i, j);
                }
            }
        }
        System.out.println(ans);
    }

    static void getDist(int r, int c) {
        int min = Math.max(sizeR, sizeC);
        for (Node shark : sharks) {
            int dist = Math.max(Math.abs(shark.r - r), Math.abs(shark.c - c));
            min = Math.min(min, dist);
        }
        ans = Math.max(ans, min);
    }

    static class Node {
        int r, c;

        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}