import java.util.Scanner;

public class Main {
    static char[][] gears;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        gears = new char[4][];
        for (int i = 0; i < 4; i++) {
            gears[i] = sc.next().toCharArray();
        }
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int idx = sc.nextInt()-1, dir = sc.nextInt();
            rotate(idx, dir);
        }
        System.out.println(score());
    }

    static int score() {
        int ans = 0, score = 1;
        for (int i = 0; i < 4; i++) {
            if (gears[i][0] == '1') {
                ans += score;
            }
            score *= 2;
        }
        return ans;
    }

    static void rotate(int idx, int dir) {
        int[] dirs = new int[4];
        int d = dir;
        dirs[idx] = d;
        for (int i = idx+1; i < 4; i++) {
            if (gears[i][6] == gears[i-1][2]) break;
            if (d == 1) {
                d = -1;
                dirs[i] = d;
            } else {
                d = 1;
                dirs[i] = d;
            }
        }
        d = dir;
        for (int i = idx-1; i >= 0; i--) {
            if (gears[i][2] == gears[i+1][6]) break;
            if (d == 1) {
                d = -1;
                dirs[i] = d;
            } else {
                d = 1;
                dirs[i] = d;
            }
        }
        for (int i = 0; i < 4; i++) {
            if (dirs[i] == 1) {
                clockwise(i);
            } else if (dirs[i] == -1) {
                counterclockwise(i);
            }
        }
    }

    static void clockwise(int idx) {
        char last = gears[idx][7];
        for (int i = 6; i >= 0 ; i--) {
            gears[idx][i + 1] = gears[idx][i];
        }
        gears[idx][0] = last;
    }

    static void counterclockwise(int idx) {
        char first = gears[idx][0];
        for (int i = 0; i < 7; i++) {
            gears[idx][i] = gears[idx][i + 1];
        }
        gears[idx][7] = first;
    }
}
