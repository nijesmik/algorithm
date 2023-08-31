import java.util.Scanner;

public class Solution {
	static int[] arr = new int[128];
	static char[][] code;
	static int n, m;

	public static void main(String[] args) {
		arr[13] = 0; arr[25] = 1; arr[19] = 2; arr[61] = 3; arr[35] = 4;
		arr[49] = 5; arr[47] = 6; arr[59] = 7; arr[55] = 8; arr[11] = 9;
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			n = sc.nextInt(); m = sc.nextInt();
			code = new char[n][];
			for (int i = 0; i < n; i++) code[i] = sc.next().toCharArray();
			System.out.printf("#%d %d\n", t, decode());
		}
	}

	static int decode() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m-56; j++) {
                int check = check(i, j);
				if (check != -1) return check; 
			}
		}
        return 0;
	}

	static int check(int i, int j) {
		int num = 0, tmp = 0, check = 0;
		for (int k = 0; k < 56; k++) {
            tmp = tmp*2 + code[i][j+k]-'0';
            if (k%7==6) {
            	if (tmp == 0) return -1;
            	if (tmp != 13 && arr[tmp] == 0) return -1;
            	num += arr[tmp];
            	check += k%2 == 0 ? arr[tmp]*3 : arr[tmp];
            	tmp = 0;
            }
        }
		return check%10==0 ? num : 0;
	}
}