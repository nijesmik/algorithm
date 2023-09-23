import java.util.Scanner;

public class Main {
	static boolean[] visit;
	static int n;
	static StringBuilder sb;
	static String[] str;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		while (true) {
			str = sc.nextLine().split(" ");
			n = Integer.parseInt(str[0]);
			if (n == 0) break;
			visit = new boolean[n];
			dfs(0, 0);
			sb.append("\n");
		}
		System.out.println(sb);
	}
	static void dfs(int idx, int level) {
		if (level == 6) {
			make();
			return;
		}
		for (int i = idx; i < n; i++) {
			visit[i] = true;
			dfs(i+1, level+1);
			visit[i] = false;
		}
	}
	static void make() {
		for (int i = 0; i < n; i++) {
			if (visit[i]) sb.append(str[i+1]+" ");
		}
		sb.append("\n");
	}
}