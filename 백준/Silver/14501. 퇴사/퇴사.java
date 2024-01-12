import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] time = new int[n];
        int[] pay = new int[n];
        int[] dpPay = new int[n+1];
        for (int i = 0; i < n; i++) {
            time[i] = sc.nextInt();
            pay[i] = sc.nextInt();
        }
        int i = n;
        while (i-- > 0) {
            if (i+time[i] <= n) {
                dpPay[i] = dpPay[i+time[i]] + pay[i];
            }
            dpPay[i] = Math.max(dpPay[i], dpPay[i+1]);
        }
        System.out.println(dpPay[0]);
    }
}
