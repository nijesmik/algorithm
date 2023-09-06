import java.io.*;
import java.util.*;

public class Main {
	static Map<Integer, List<Integer[]>> map;
	static int n, ans, end;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			List<Integer[]> list = new ArrayList<>();
			while (true) {
				int to = Integer.parseInt(st.nextToken());
				if (to < 0) break;
				list.add(new Integer[]{to, Integer.parseInt(st.nextToken())});
			}
			map.put(from, list);
		}
		ans = 0;
		dfs(1, 0, 0);
		dfs(end, 0, 0);
		System.out.println(ans);
	}
	static void dfs(int cur, int len, int prev) {
		if (len > ans) {
			ans = len;
			end = cur;
		}
		for (Integer[] arr : map.get(cur)) {
			if (arr[0] != prev)
				dfs(arr[0], len+arr[1], cur);
		}
	}
}