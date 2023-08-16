import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			sc.nextInt();
			String line = sc.next();
			System.out.printf("#%d %d\n", t, check(line.split("")));
		}
	}
	static int check(String[] strs) {
		Stack<String> stack = new Stack<>();
		for (String str : strs) {
			if (str.equals("(") || str.equals("[") || str.equals("<") || str.equals("{"))
				stack.push(str);
			else if (str.equals(")")) {
				if (stack.peek().equals("(")) stack.pop();
				else return 0;
			} else if (str.equals(">")) {
				if (stack.peek().equals("<")) stack.pop();
				else return 0;
			} else if (str.equals("]")) {
				if (stack.peek().equals("[")) stack.pop();
				else return 0;
			} else {
				if (stack.peek().equals("{")) stack.pop();
				else return 0;
			}
		}
		return 1;
	}
}