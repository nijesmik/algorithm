import java.util.Scanner;

public class Main {
    static int N, max;
    static int[] dr = { 1, 0 }, dc = { 0, 1 };
    static char[][] candies;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        candies = new char[N][];
        for (int i = 0; i < N; i++) {
            candies[i] = sc.next().toCharArray();
            max = Math.max(max, testRow(candies[i]));
        }
        for (int i = 0; i < N; i++) {
            max = Math.max(max, testColumn(i));
        }
        if (max == N) {
            System.out.println(max);
            return;
        }
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                test(r, c);
            }
        }
        System.out.println(max);
    }

    static void test(int r, int c) {
        for (int i = 0; i < 2; i++) {
            int nr = r + dr[i], nc = c + dc[i];
            if (nr < 0 || nr >= N || nc < 0 || nc >= N || candies[r][c] == candies[nr][nc]) {
                return;
            }
            swap(r, c, nr, nc);
            max = Math.max(max, testRow(candies[r]));
            max = Math.max(max, testRow(candies[nr]));
            max = Math.max(max, testColumn(c));
            max = Math.max(max, testColumn(nc));
            swap(r, c, nr, nc);
        }
    }

    static void swap(int r1, int c1, int r2, int c2) {
        char tmp = candies[r1][c1];
        candies[r1][c1] = candies[r2][c2];
        candies[r2][c2] = tmp;
    }

    static int testColumn(int index) {
        char[] column = new char[N];
        for (int i = 0; i < N; i++) {
            column[i] = candies[i][index];
        }
        return testRow(column);
    }

    static int testRow(char[] row) {
        char candy = row[0];
        int count = 1, max = 0;
        for (int i = 1; i < N; i++) {
            if (row[i] == candy) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 1;
                candy = row[i];
            }
        }
        return Math.max(max, count);
    }
}