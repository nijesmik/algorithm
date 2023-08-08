import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			int dump = sc.nextInt();
			int[] arr = new int[100];
			for (int i = 0; i < 100; i++) arr[i] = sc.nextInt();
			Arrays.sort(arr);
			int max_ptr = 99;
			int min_ptr = 0;
			while (arr[0] == arr[min_ptr+1]) min_ptr++;
			while (arr[99] == arr[max_ptr-1]) max_ptr--;
			int max_cur = max_ptr;
			int min_cur = min_ptr;
			while (dump-- > 0 && max_ptr > min_ptr) {
				arr[max_cur++] -= 1;
				arr[min_cur--] += 1;
				while (arr[0] == arr[min_ptr+1]) min_ptr++;
				while (arr[99] == arr[max_ptr-1]) max_ptr--;
				if (min_cur == -1) min_cur = min_ptr;
				if (max_cur == 100) max_cur = max_ptr;
			}
			System.out.printf("#%d %d\n", t, arr[99] - arr[0]);
		}
	}
}
