import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int K = sc.nextInt();
			Stack<Integer> stack = new Stack<>();
			for (int k = 0; k < K; k++) {
				int tmp = sc.nextInt();
				if (tmp == 0) stack.pop();
				else stack.push(tmp);
			}
			int sum = 0;
			for (int num : stack) sum += num;
			System.out.printf("#%d %d\n", t, sum);
		}
	}
}