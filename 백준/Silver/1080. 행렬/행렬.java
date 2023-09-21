import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static char[][] before, after;
	static int rsize, csize;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		rsize = Integer.parseInt(st.nextToken());
		csize = Integer.parseInt(st.nextToken());
		before = new char[rsize][];
		after = new char[rsize][];
		for (int i = 0; i < rsize; i++) {
			before[i] = br.readLine().toCharArray();
		}
		for (int i = 0; i < rsize; i++) {
			after[i] = br.readLine().toCharArray();
		}
		int cnt = 0;
		for (int i = 0; i < rsize-2; i++) {
			for (int j = 0; j < csize-2; j++) {
				if (before[i][j] != after[i][j]) {
					flip(i, j);
					cnt++;
				}
			}
		}
		if (wrong()) cnt = -1;
		System.out.println(cnt);
	}
	static boolean wrong() {
		for (int i = 0; i < rsize; i++) {
			for (int j = 0; j < csize; j++) {
				if (before[i][j] != after[i][j])
					return true;
			}
		}
		return false;
	}
	static void flip(int r, int c) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				char ch = before[r+i][c+j];
				if (ch == '0') before[r+i][c+j] = '1';
				else before[r+i][c+j] = '0';
			}
		}
	}
}