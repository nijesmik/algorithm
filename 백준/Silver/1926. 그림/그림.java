import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int rowsize, colsize, picture[][];
    static boolean[][] visited;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        rowsize = scanner.nextInt(); colsize = scanner.nextInt();
        picture = new int[rowsize][colsize];
        for (int i = 0; i < rowsize; i++) {
            for (int j = 0; j < colsize; j++) {
                picture[i][j] = scanner.nextInt();
            }
        }
        int count = 0, max = 0;
        for (int i = 0; i < rowsize; i++) {
            for (int j = 0; j < colsize; j++) {
                if (picture[i][j] == 1) {
                    count++;
                    max = Math.max(max, bfs(i, j));
                }
            }
        }
        System.out.println(count);
        System.out.println(max);
    }

    static int[] dr = {1, -1, 0, 0}, dc = {0, 0, 1, -1};
    static int bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        picture[r][c]++;
        q.add(new int[]{r, c});
        int size = 1;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nr = cur[0] + dr[i], nc = cur[1] + dc[i];
                if (nr >= 0 && nr < rowsize && nc >= 0 && nc < colsize && picture[nr][nc] == 1) {
                    picture[nr][nc]++;
                    q.add(new int[]{nr, nc});
                    size++;
                }
            }
        }
        return size;
    }
}
