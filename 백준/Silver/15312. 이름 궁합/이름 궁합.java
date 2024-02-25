import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] score = new int[] { 3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1 };
        Scanner sc = new Scanner(System.in);
        String me = sc.next();
        String her = sc.next();
        int N = me.length();
        int[] test = new int[N * 2];
        for (int i = 0; i < N; i++) {
            test[2 * i] = score[me.charAt(i) - 'A'];
            test[2 * i + 1] = score[her.charAt(i) - 'A'];
        }
        for (int i = 2 * N - 1; i > 1; i--) {
            for (int j = 0; j < i; j++) {
                test[j] = (test[j] + test[j + 1]) % 10;
            }
        }
        System.out.println("" + test[0] + test[1]);
    }
}