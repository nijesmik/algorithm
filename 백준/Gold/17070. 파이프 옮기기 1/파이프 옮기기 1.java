import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int N, map[][], ans;
    static Direction[] directions;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        // 0 : 가로, 1 : 세로, 2 : 대각선
        directions = new Direction[3];
        for (int i = 0; i < 3; i++) {
            directions[i] = new Direction();
            if (i != 1)
                directions[i].deltas.add(new int[] { 0, 1, 0 });
            if (i != 0)
                directions[i].deltas.add(new int[] { 1, 0, 1 });
            directions[i].deltas.add(new int[] { 1, 1, 2 });

        }

        ans = 0;
        dfs(0, 1, 0);
        System.out.println(ans);
    }

    static void dfs(int r, int c, int dirIdx) {
        if (r == N - 1 && c == N - 1) {
            ans++;
            return;
        }

        for (int[] delta : directions[dirIdx].deltas) {
            int nr = r + delta[0], nc = c + delta[1];
            if (nr < 0 || nr >= N || nc < 0 || nc >= N)
                continue;
            if (delta[2] == 2 && (map[nr - 1][nc] == 1 || map[nr][nc - 1] == 1))
                continue;
            if (map[nr][nc] == 0) {
                dfs(nr, nc, delta[2]);
            }
        }
    }

    static class Direction {
        List<int[]> deltas = new ArrayList<>();
    }
}