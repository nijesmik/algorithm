import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), k = sc.nextInt(), cnt = 0;
		int[] arr = new int[n];
		while (n-- > 0) arr[n] = sc.nextInt();
		for (int i : arr) {
			if (k >= i) {
				cnt += k/i;
				k %= i;
			}
		}
		System.out.println(cnt);
	}
}