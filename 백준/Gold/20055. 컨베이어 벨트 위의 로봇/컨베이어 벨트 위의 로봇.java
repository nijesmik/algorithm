import java.util.Scanner;

public class Main {
    static int N, K, belt[], cnt;
    static boolean hasRobot[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        belt = new int[2 * N];
        hasRobot = new boolean[N];
        for (int i = 0; i < 2 * N; i++) {
            belt[i] = sc.nextInt();
        }
        cnt = 0;
        int time = 0;
        while (cnt < K) {
            firstStep();
            secondStep();
            if (!hasRobot[0] && belt[0] > 0) {
                hasRobot[0] = true;
                belt[0]--;
                if (belt[0] == 0)
                    cnt++;
            }
            time++;
        }
        System.out.println(time);
    }

    static void secondStep() {
        int idx = N - 1;
        while (idx-- > 0) {
            if (hasRobot[idx] && !hasRobot[idx + 1] && belt[idx + 1] > 0) {
                hasRobot[idx] = false;
                hasRobot[idx + 1] = true;
                belt[idx + 1]--;
                if (belt[idx + 1] == 0)
                    cnt++;
            }
        }
        if (hasRobot[N - 1]) {
            hasRobot[N - 1] = false;
        }
    }

    static void firstStep() {
        int idx = N - 1;
        while (idx-- > 0) {
            hasRobot[idx + 1] = hasRobot[idx];
        }
        hasRobot[0] = false;
        idx = 2 * N - 1;
        int lastBelt = belt[idx];
        while (idx-- > 0) {
            belt[idx + 1] = belt[idx];
        }
        belt[0] = lastBelt;
        if (hasRobot[N - 1]) {
            hasRobot[N - 1] = false;
        }
    }
}
