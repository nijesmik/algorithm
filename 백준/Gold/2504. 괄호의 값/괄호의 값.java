import java.util.*;

public class Main {
	public static void main(String[] args) {
		Stack<Character> stack = new Stack<>();
		Scanner sc = new Scanner(System.in);
		char[] input = sc.next().toCharArray();
		int ans = 0, tmp = 1;
		for (int i = 0; i < input.length; i++) {
			char c = input[i];
			if (c == '(') {
				tmp *= 2;
				stack.push(c);
			} else if (c == '[') {
				tmp *= 3;
				stack.push(c);
			} else if (stack.empty()) {
				ans = 0;
				break;
			} else if (c == ']' && stack.peek() == '[') {
				if (input[i - 1] == '[')
					ans += tmp;
				stack.pop();
				tmp /= 3;
			} else if (c == ')' && stack.peek() == '(') {
				if (input[i - 1] == '(')
					ans += tmp;
				stack.pop();
				tmp /= 2;
			} else {
				ans = 0;
				break;
			}
		}
        if (!stack.empty()) ans = 0;
		System.out.println(ans);
	}
}