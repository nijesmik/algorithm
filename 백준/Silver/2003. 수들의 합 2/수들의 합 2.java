import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberCount = sc.nextInt();
        int answer = sc.nextInt();
        int[] numbers = new int[numberCount];
        for (int i = 0; i < numberCount; i++) {
            numbers[i] = sc.nextInt();
        }
        int start = 0, sum = 0, count = 0;
        for (int end = 0; end < numberCount; end++) {
            sum += numbers[end];
            while (sum >= answer) {
                if (sum == answer) count++;
                sum -= numbers[start++];
            }
        }
        System.out.println(count);
    }
}
