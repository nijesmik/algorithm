import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	static Stack<Character> operator = new Stack<>();
	static Stack<Integer> num = new Stack<>();
	static HashMap<Character, Integer> prior = new HashMap<>();

	public static void main(String[] args) {
		prior.put('(', 0);
		prior.put(')', 1);
		prior.put('+', 2);
		prior.put('-', 2);
		prior.put('*', 3);
		prior.put('/', 3);
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			sc.nextInt();
			String str = sc.next();
			for (char c : str.toCharArray()) {
				if ('0' <= c && c <= '9') num.push(c - '0');
				else operate(c);
			}
			System.out.printf("#%d %d\n", t, num.peek());
		}
	}
	static void operate(char c) {
		if (c == '(') {
			operator.push(c);
			return;
		}
		while (prior.get(operator.peek()) >= prior.get(c))
			num.push(calc(num.pop(), operator.pop(), num.pop()));
		if (c == ')') operator.pop();
		else operator.push(c);
	}
	static int calc(int b, char c, int a) {
		if (c == '+')
			return a+b;
		else if (c == '-')
			return a-b;
		else if (c == '/')
			return a/b;
		else
			return a*b;
	}
}