import java.util.Scanner;

public class Solution {
	static String[] data;
	static int[] left, right;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			int n = Integer.parseInt(sc.nextLine());
			data = new String[n+1];
			left = new int[n+1];
			right = new int[n+1];
			for (int i = 1; i <= n; i++) {
				String[] tmp = sc.nextLine().split(" ");
				data[i] = tmp[1];
				if (tmp.length == 4) {
                    left[i] = Integer.parseInt(tmp[2]);
                	right[i] = Integer.parseInt(tmp[3]);
                }
			}
			System.out.printf("#%d %d\n", t, calc(1));
		}
	}
	static int calc(int idx) {
		if (left[idx] + right[idx] == 0) 
			return Integer.parseInt(data[idx]);
		int a = calc(left[idx]);
		int b = calc(right[idx]);
        char c = data[idx].charAt(0);
		if (c == '+') return a+b;
		else if (c == '-') return a-b;
		else if (c == '*') return a*b;
		else return a/b;
	}
}