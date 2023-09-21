import java.util.*;

public class Solution {
	static char[] arr;
	static Set<Integer> set;
	static int n, k;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			n = sc.nextInt();
			k = sc.nextInt();
			arr = sc.next().toCharArray();
			set = new HashSet<>();
			for (int j = 0; j < n/4; j++) {
				createNum(j);
			}
			List<Integer> list = new ArrayList<>(set);
			list.sort(Comparator.reverseOrder());
			System.out.printf("#%d %d\n", t, list.get(k-1));
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
			set.add(Integer.parseInt(num, 16));
		}
	}
}