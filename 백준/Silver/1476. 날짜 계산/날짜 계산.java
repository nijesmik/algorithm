import java.util.Scanner;

public class Main {
    static int[] target;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        target = new int[3];
        for (int i = 0; i < 3; i++) {
            target[i] = sc.nextInt();
        }
        System.out.println(answer());
    }

    static int answer() {
        int num = 1;
        while (true) {
            int e = num % 15;
            if (e == 0) e = 15;
            int s = num % 28;
            if (s == 0) s = 28;
            int m = num % 19;
            if (m == 0) m = 19;
            if (e == target[0] && s == target[1] && m == target[2])
                return num;
            num++;
        }
    }
}
