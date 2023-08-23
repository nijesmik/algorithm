import java.util.Scanner;

class Main {
	static char[][] tree = new char[26][2];
	static String[] ans = new String[3];

	public static void main(String[] args) {
		ans[0] = ""; ans[1] = ""; ans[2] = "";
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int idx = sc.next().charAt(0) - 'A';
			tree[idx][0] = sc.next().charAt(0);
			tree[idx][1] = sc.next().charAt(0);
		}
		getAns('A');
		System.out.println(ans[0]);
		System.out.println(ans[1]);
		System.out.println(ans[2]);
	}

	static void getAns(char c) {
		if (c == '.') return;
		ans[0] += c; 
		getAns(tree[c - 'A'][0]);
		ans[1] += c; 
		getAns(tree[c - 'A'][1]);
		ans[2] += c; 
	}
}