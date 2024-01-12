import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] time = new int[n];
        int[] pay = new int[n];
        int[] dpPay = new int[n];
        for (int i = 0; i < n; i++) {
            time[i] = sc.nextInt();
            pay[i] = sc.nextInt();
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            int curPay = 0;
            if (i+time[i] <= n) {
                curPay = pay[i];
            }
            for (int j = 0; j <= i; j++) {
                int totalPay = curPay;
                if (j+time[j] <= i) {
                    totalPay += dpPay[j];
                }
                dpPay[i] = Math.max(dpPay[i], totalPay);
            }
            max = Math.max(max, dpPay[i]);
        }
        System.out.println(max);
    }
}