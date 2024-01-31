import java.util.Scanner;

public class Main {
    static int arr[][];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rowSize = sc.nextInt(), colSize = sc.nextInt(), count = sc.nextInt();
        arr = new int[rowSize][colSize];
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int min = Math.min(rowSize, colSize);
        for (int i = 0; i < min / 2; i++) {
            int rowEnd = rowSize - i, colEnd = colSize - i;
            int cnt = count % ((rowEnd - i + colEnd - i - 2) * 2);
            while (cnt-- > 0) {
                rotate(i, rowEnd, colEnd);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                sb.append(arr[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static int[] dr = { 1, 0, -1, 0 }, dc = { 0, 1, 0, -1 };

    static void rotate(int start, int rowEnd, int colEnd) {
        int r = start, c = start, prev = arr[r][c], dir = 0;
        while (dir < 4) {
            r += dr[dir];
            c += dc[dir];
            if (r < start || c < start || r >= rowEnd || c >= colEnd) {
                r -= dr[dir];
                c -= dc[dir];
                dir++;
            } else {
                int tmp = arr[r][c];
                arr[r][c] = prev;
                prev = tmp;
            }
        }
    }
}
