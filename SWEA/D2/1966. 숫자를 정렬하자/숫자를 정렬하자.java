import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
			Arrays.sort(arr);
			System.out.printf("#%d", t);
			for (int i : arr) System.out.printf(" %d", i);
			System.out.println();
		}
	}
}