import java.util.Scanner;

public class Main {
    static int N, arr[];
    static boolean visited[], flag;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        flag = false;
        visited = new boolean[N+1];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            visited[i+1] = true;
        }

        int idx = N - 1;
        visited[arr[idx]] = false;
        while (idx-- > 0 && !flag) {
            visited[arr[idx]] = false;
            permutation(idx, arr[idx] + 1);
        }
        if (!flag) {
            System.out.println(-1);
        }
    }

    static void print() {
        for (int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static void permutation(int depth, int start) {
        if (depth == N) {
            if (!flag) {
                flag = true;
                print();
            }
            return;
        }
        for (int i = start; i < N+1; i++) {
            if (!visited[i]) {
                arr[depth] = i;
                visited[i] = true;
                permutation(depth+1, 1);
                visited[i] = false;
            }
        }
    }
}
