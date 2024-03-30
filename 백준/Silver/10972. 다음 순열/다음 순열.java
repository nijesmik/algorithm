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
        int top = n - 1;
        while (top > 0 && arr[top - 1] > arr[top]) {
            top--;
        }
        if (top == 0) {
            System.out.println(-1);
            return;
        }
        int target = n - 1;
        while (arr[top - 1] > arr[target]) {
            target--;
        }
        swap(top - 1, target);
        target = n - 1;
        while (top < target) {
            swap(top++, target--);
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