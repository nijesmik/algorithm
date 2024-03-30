import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cmp = 9, digit = 1;
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (i > cmp) {
                cmp = cmp * 10 + 9;
                digit++;
            }
            ans += digit;
        }
        System.out.println(ans);
    }
}