import java.io.*;
import java.util.*;

public class Main {
	static Map<Integer, List<Integer[]>> map;
	static boolean[] visit;
	static int n, ans, end;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		map = new HashMap<>();
		visit = new boolean[n+1];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			List<Integer[]> list = new ArrayList<>();
			int end = Integer.parseInt(st.nextToken());
			while (end > 0) {
				list.add(new Integer[]{end, Integer.parseInt(st.nextToken())});
				end = Integer.parseInt(st.nextToken());
			}
			map.put(start, list);
		}
		ans = 0;
		dfs(1, 0);
		dfs(end, 0);
		System.out.println(ans);
	}
	static void dfs(int i, int len) {
		if (visit[i]) return;
		visit[i] = true;
		if (len > ans) {
			ans = len;
			end = i;
		}
		for (Integer[] arr : map.get(i))
			dfs(arr[0], len+arr[1]);
		visit[i] = false;
	}
}