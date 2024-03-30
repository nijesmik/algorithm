import java.util.Scanner;

public class Main {
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int bottom = n - 1;
        while (bottom > 0 && arr[bottom - 1] < arr[bottom]) {
            bottom--;
        }
        if (bottom == 0) {
            System.out.println(-1);
            return;
        }
        int target = n - 1;
        while (arr[bottom - 1] < arr[target]) {
            target--;
        }
        swap(bottom - 1, target);
        target = n - 1;
        while (bottom < target) {
            swap(bottom++, target--);
        }
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static void swap(int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}