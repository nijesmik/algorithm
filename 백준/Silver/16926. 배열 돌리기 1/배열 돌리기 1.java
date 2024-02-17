import java.util.Scanner;

public class Main {
    static int sizeR, sizeC, arr[][];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sizeR = sc.nextInt();
        sizeC = sc.nextInt();
        int count = sc.nextInt();
        arr = new int[sizeR][sizeC];
        for (int i = 0; i < sizeR; i++) {
            for (int j = 0; j < sizeC; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        while (count-- > 0) {
            rotate();
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sizeR; i++) {
            for (int j = 0; j < sizeC; j++) {
                sb.append(arr[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static int[] dr = { 0, 1, 0, -1 }, dc = { 1, 0, -1, 0 };

    static void rotate() {
        int n = Math.min(sizeR / 2, sizeC / 2);
        for (int i = 0; i < n; i++) {
            int r = i, c = i, dir = 0, tmp = arr[i][i];
            while (dir < 4) {
                int nr = r + dr[dir], nc = c + dc[dir];
                if (nr < i || nr >= sizeR - i || nc < i || nc >= sizeC - i) {
                    dir++;
                } else {
                    arr[r][c] = arr[nr][nc];
                    r = nr;
                    c = nc;
                }
            }
            arr[i + 1][i] = tmp;
        }
    }
}