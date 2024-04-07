import java.util.Scanner;

public class Main {
    static int dvdSize, lectures[], ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lectureSize = sc.nextInt();
        dvdSize = sc.nextInt();

        lectures = new int[lectureSize];
        int end = 0;
        int start = 0;
        for (int i = 0; i < lectureSize; i++) {
            lectures[i] = sc.nextInt();
            end += lectures[i];
            start = Math.max(start, lectures[i]);
        }

        while (start <= end) {
            int mid = (start + end) / 2;
            if (isPossible(mid)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(ans);
    }

    static boolean isPossible(int time) {
        int sum = 0;
        int dvd = 0;
        for (int lecture : lectures) {
            sum += lecture;
            if (sum < time) {
                continue;
            }
            dvd++;
            if (sum > time) {
                sum = lecture;
            } else {
                sum = 0;
            }
        }
        if (sum > 0) {
            dvd++;
        }
        if (dvd <= dvdSize) {
            ans = time;
            return true;
        }
        return false;
    }
}