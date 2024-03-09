import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		PriorityQueue<Integer> a = new PriorityQueue<>((x, y) -> x - y);
		PriorityQueue<Integer> b = new PriorityQueue<>((x, y) -> y - x);
		for (int i = 0; i < n; i++) {
			a.add(sc.nextInt());
		}
		for (int i = 0; i < n; i++) {
			b.add(sc.nextInt());
		}
		int ans = 0;
		while (n-- > 0) {
			ans += a.poll() * b.poll();
		}
		System.out.println(ans);
	}
}