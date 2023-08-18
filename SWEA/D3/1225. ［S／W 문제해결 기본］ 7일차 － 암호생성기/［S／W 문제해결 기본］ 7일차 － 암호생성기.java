import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			LinkedList<Integer> queue = new LinkedList<>();
			sc.nextInt();
			for (int i = 0; i < 8; i++) queue.offer(sc.nextInt());
			pw(queue);
			String str = "#"+t;
			for (int i : queue) str += " "+i;
			System.out.println(str);
		}
	}
	static void pw(LinkedList<Integer> queue) {
		while (true) {
			for (int i = 1; i <= 5; i++) {
				int tmp = queue.poll() - i;
				queue.offer(Math.max(tmp, 0));
				if (tmp <= 0) return ;
			}
		}

	}
}