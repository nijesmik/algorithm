import java.util.*;

public class Solution {
	static Map<String, Integer> map = new HashMap<>();
	static String[] code;
	static int n, m;

	public static void main(String[] args) {
		map.put("0001101",0); map.put("0011001",1);
		map.put("0010011",2); map.put("0111101",3);
		map.put("0100011",4); map.put("0110001",5);
		map.put("0101111",6); map.put("0111011",7);
		map.put("0110111",8); map.put("0001011",9);
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			n = sc.nextInt(); m = sc.nextInt();
			code = new String[n];
			for (int i = 0; i < n; i++) code[i] = sc.next();
			System.out.printf("#%d %d\n", t, decode());
		}
	}

	static int decode() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m-56; j++) {
				int check = check(code[i], j);
				if (check != -1) return check;
			}
		}
		return 0;
	}

	static int check(String str, int idx) {
		int num = 0, check = 0;
		for (int i = 0; i < 8; i++) {
			Integer tmp = map.get(str.substring(idx+i*7, idx+i*7+7));
			if (tmp == null) return -1;
			num += tmp;
			check += i%2 == 0 ? tmp*3 : tmp;
		}
		return check%10==0 ? num : 0;
	}
}