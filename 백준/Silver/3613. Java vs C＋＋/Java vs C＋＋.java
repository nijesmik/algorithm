import java.util.Scanner;

public class Main {
	static StringBuilder sb;
	static int n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		String ans = convert(input.toCharArray(), input.contains("_"));
		System.out.println(ans);
	}

	static String convert(char[] words, boolean cpp) {
		n = words.length;
		if (!Character.isLowerCase(words[0]) || words[n - 1] == '_') {
			return "Error!";
		}
		sb = new StringBuilder();
		if (cpp) {
			return toJavaFormat(words);
		}
		return toCppFormat(words);
	}

	static String toCppFormat(char[] words) {
		for (char c : words) {
			if (c < 'a') {
				sb.append('_');
				c = Character.toLowerCase(c);
			}
			sb.append(c);
		}
		return sb.toString();
	}

	static String toJavaFormat(char[] words) {
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