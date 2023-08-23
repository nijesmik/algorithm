import java.util.Scanner;

public class Solution {
	static String[] data;
	static int[][] link;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			int n = Integer.parseInt(sc.nextLine());
			data = new String[n+1];
			link = new int[n+1][2];
			for (int i = 1; i <= n; i++) {
				String[] tmp = sc.nextLine().split(" ");
				data[i] = tmp[1];
				if (tmp.length == 4) {
                    link[i][0] = Integer.parseInt(tmp[2]);
                	link[i][1] = Integer.parseInt(tmp[3]);
                }
			}
			System.out.printf("#%d %d\n", t, calc(1));
		}
	}
	static int calc(int idx) {
		if (link[idx][0] + link[idx][1] == 0) 
			return Integer.parseInt(data[idx]);
		int a = calc(link[idx][0]);
		int b = calc(link[idx][1]);
        char c = data[idx].charAt(0);
		if (c == '+') return a+b;
		else if (c == '-') return a-b;
		else if (c == '*') return a*b;
		else return a/b;
	}
}