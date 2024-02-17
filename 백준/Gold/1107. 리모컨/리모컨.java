import java.util.*;

public class Main {
    static int target, ans;
    static boolean[] disable;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String targetString = sc.next();
        target = Integer.parseInt(targetString);
        int n = sc.nextInt();
        disable = new boolean[10];
        while (n-- > 0) {
            disable[sc.nextInt()] = true;
        }
        int number = 0;
        ans = Math.abs(target - 100);
        while (number < 9_999_999) {
            int digit = test(number);
            if (digit > 0) {
                ans = Math.min(ans, Math.abs(target - number) + digit);
            }
            number++;
        }
        System.out.println(ans);
    }

    static int test(int number) {
        if (number == 0 && !disable[0]) {
            return 1;
        }
        int digit = 0;
        while (number > 0) {
            if (disable[number % 10]) {
                return 0;
            }
            number /= 10;
            digit++;
        }
        return digit;
    }
}