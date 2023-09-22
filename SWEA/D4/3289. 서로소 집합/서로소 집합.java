import java.io.*;
import java.util.StringTokenizer;

public class Solution {
	static int[] rep;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		for (int t = 1; t <= tc; t++) {
			sb.append("#"+t+" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			rep = new int[n+1];
			for (int i = 0; i <= n; i++) {
				rep[i] = i;
			}
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int cmd = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				command(cmd, a, b);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	static int findSet(int idx) {
		if (idx != rep[idx])
			rep[idx] = findSet(rep[idx]);
		return rep[idx];
	}
	static void command(int cmd, int a, int b) {
		int repA = findSet(a);
		int repB = findSet(b);
		if (cmd == 0)
			rep[repB] = repA;
		else {
			int output = 0;
			if (repA == repB) output = 1;
			sb.append(output);
		}
	}
}