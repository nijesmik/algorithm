import java.util.Scanner;

public class Main {
    static int wireCount;
    static long wires[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        wireCount = sc.nextInt();
        long target = sc.nextLong();
        wires = new long[wireCount];
        long start = 1, end = 0;
        for (int i = 0; i < wireCount; i++) {
            wires[i] = sc.nextLong();
            end = Math.max(end, wires[i]);
        }
        long ans = 0;
        while (start <= end) {
            long mid = (start + end) / 2;
            long cutCount = cut(mid);
            if (cutCount < target) {
                end = mid - 1;
            } else {
                ans = Math.max(ans, mid);
                start = mid + 1;
            }
        }
        System.out.println(ans);
    }
    static long cut(long cutSize) {
        long ans = 0;
        for (int i = 0; i < wireCount; i++) {
            ans += wires[i] / cutSize;
        }
        return ans;
    }
}
