import java.util.*;

public class Main {
	static StringBuilder sb;
	static char[] words;
	static int n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();

		words = input.toCharArray();
		n = words.length;

		String ans = convert(input.contains("_"));
		System.out.println(ans);
	}

	static String convert(boolean isCpp) {
		if (!Character.isLowerCase(words[0]) || words[n - 1] == '_') {
			return "Error!";
		}
		sb = new StringBuilder();
		if (isCpp) {
			return toJava();
		}
		return toCpp();
	}

	static String toCpp() {
		for (char c : words) {
			if (c < 'a') {
				sb.append('_');
				c = Character.toLowerCase(c);
			}
			sb.append(c);
		}
		return sb.toString();
	}

	static String toJava() {
		int i = 0;
		while (i < n) {
			char c = words[i++];
			if (c >= 'A' && c <= 'Z') {
				return "Error!";
			}
			if (c == '_') {
				if (!Character.isLowerCase(words[i])) {
					return "Error!";
				}
				c = Character.toUpperCase(words[i++]);
			}
			sb.append(c);
		}
		return sb.toString();
	}
}