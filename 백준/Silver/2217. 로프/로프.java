import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> rope = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < N; i++) {
            rope.add(sc.nextInt());
        }
        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, rope.poll() * i);
        }
        System.out.println(max);
    }
}