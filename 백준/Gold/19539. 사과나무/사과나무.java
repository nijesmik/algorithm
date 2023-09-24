import java.io.*;
import java.util.*;

public class Main {
	static Integer[] want;
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		want = new Integer[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			want[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(want);
		String ans = "YES";
		for (int i = 0; i < n; i++) {
			want[i] %= 3;
			if (want[i] != 0 && !minus(i, 3-want[i])) {
				ans = "NO";
				break;
			}
		}
		System.out.println(ans);
	}
	static boolean minus(int idx, int val) {
		for (int i = n-1; i > idx; i--) {
			if (want[i] >= val) {
				want[i] -= val;
				return true;
			}
		}
		return false;
	}
}