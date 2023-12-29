import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int R, C;
    static char[][] map;
    static List<Sheep> sheeps;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt(); C = sc.nextInt();
        map = new char[R][];
        sheeps = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            map[i] = sc.next().toCharArray();
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'S') {
                    sheeps.add(new Sheep(i, j));
                }
            }
        }
        int ans = fence();
        System.out.println(ans);
        if (ans == 1) {
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
        }
    }

    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int fence() {
        for (Sheep sheep : sheeps) {
            for (int i = 0; i < 4; i++) {
                int nr = sheep.r + dr[i], nc = sheep.c + dc[i];
                if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
                    if (map[nr][nc] == 'W') return 0;
                    if (map[nr][nc] == '.') map[nr][nc] = 'D';
                }
            }
        }
        return 1;
    }

    static class Sheep {
        int r, c;
        Sheep(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}