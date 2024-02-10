import java.util.Scanner;

public class Main {
    static int sizeR, sizeC, arr[][];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sizeR = sc.nextInt();
        sizeC = sc.nextInt();
        int sizeCmd = sc.nextInt();
        arr = new int[sizeR][sizeC];
        for (int i = 0; i < sizeR; i++) {
            for (int j = 0; j < sizeC; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        while (sizeCmd-- > 0) {
            int cmd = sc.nextInt();
            if (cmd <= 2) {
                arr = flip(cmd);
            } else if (cmd <= 4) {
                arr = rotate(cmd);
            } else if (cmd <= 6) {
                arr = moveGroup(cmd - 5);
            }
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

    static int[][] moveGroup(int cmd) {
        int[][] newArr = new int[sizeR][sizeC];
        int[] dr = { 0, 0, sizeR / 2, sizeR / 2 }, dc = { 0, sizeC / 2, sizeC / 2, 0 };
        for (int k = 0; k < 4; k++) {
            for (int i = 0; i < sizeR / 2; i++) {
                for (int j = 0; j < sizeC / 2; j++) {
                    int t = (k + 1 + cmd * 2) % 4;
                    newArr[i + dr[t]][j + dc[t]] = arr[i + dr[k]][j + dc[k]];
                }
            }
        }
        return newArr;
    }

    static int[][] rotate(int cmd) {
        int[][] newArr = new int[sizeC][sizeR];
        for (int i = 0; i < sizeR; i++) {
            for (int j = 0; j < sizeC; j++) {
                if (cmd == 3) {
                    newArr[j][sizeR - 1 - i] = arr[i][j];
                } else {
                    newArr[sizeC - 1 - j][i] = arr[i][j];
                }
            }
        }
        int tmp = sizeC;
        sizeC = sizeR;
        sizeR = tmp;
        return newArr;
    }

    static int[][] flip(int cmd) {
        int[][] newArr = new int[sizeR][sizeC];
        for (int i = 0; i < sizeR; i++) {
            for (int j = 0; j < sizeC; j++) {
                if (cmd == 1) {
                    newArr[i][j] = arr[sizeR - 1 - i][j];
                } else {
                    newArr[i][j] = arr[i][sizeC - 1 - j];
                }
            }
        }
        return newArr;
    }
}
