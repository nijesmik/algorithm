import java.util.*;

public class Solution {
	static char[] arr;
	static List<Integer> list;
	static int n, k, prev, ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			n = sc.nextInt();
			k = sc.nextInt();
			arr = sc.next().toCharArray();
			list = new ArrayList<>();
			for (int j = 0; j < n/4; j++) {
				createNum(j);
			}
			prev = 0;
			list.stream().sorted(Comparator.reverseOrder()).forEach(a->{
				if (a != prev) k--;
				if (k == 0) ans = a;
                prev = a;
			});
			System.out.printf("#%d %d\n", t, ans);
		}
	}
	static void createNum(int idx) {
		char[] tmp = new char[n];
		for (int i = 0; i < n; i++)
			tmp[i] = arr[(i+idx)%n];
		for (int i = 0; i < n; i+=n/4) {
			String num = "";
			for (int j = 0; j < n/4; j++)
				num += tmp[i+j];
			list.add(Integer.parseInt(num, 16));
		}
	}
}