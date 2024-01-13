import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rowSize = sc.nextInt(), columnSize = sc.nextInt();
        int x = sc.nextInt(), y = sc.nextInt();
        int[][] arr = new int[rowSize + x][columnSize + y];
        for (int i = 0; i < rowSize + x; i++) {
            for (int j = 0; j < columnSize + y; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        for (int i = x; i < rowSize; i++) {
            for (int j = y; j < columnSize; j++) {
                arr[i][j] -= arr[i-x][j-y];
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < columnSize; j++) {
                sb.append(arr[i][j]);
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
