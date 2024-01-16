import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            System.out.println(hasNumber(sc.nextInt()));
        }
    }

    static int hasNumber(int num) {
        if (Arrays.binarySearch(arr, num) < 0)
            return 0;
        return 1;
    }
}
